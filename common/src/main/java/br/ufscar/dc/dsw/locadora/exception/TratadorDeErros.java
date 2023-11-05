package br.ufscar.dc.dsw.locadora.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
public class TratadorDeErros {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity tratarErro404() {
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity tratarErro400(MethodArgumentNotValidException ex) {
    List<FieldError> erros = ex.getFieldErrors();

    List<DadosErroValidacao> messages = new ArrayList<>(erros.size());

    erros.forEach(erro -> {
      // Se houver mais de uma mensagem de erro para o mesmo campo, adiciona a mensagem na lista de mensagens
      if (messages.stream().anyMatch(dadosErroValidacao -> Objects.equals(dadosErroValidacao.field(), erro.getField()))) {
        DadosErroValidacao dados = messages.stream().filter(dadosErroValidacao ->
            Objects.equals(dadosErroValidacao.field(), erro.getField())
        ).findFirst().get();

        messages.remove(dados);
        List<String> mensagens = dados.messages();
        String erroMessage = erro.getDefaultMessage();
        mensagens.add(erroMessage);
        messages.add(new DadosErroValidacao(erro.getField(), mensagens));
      } else {
        messages.add(new DadosErroValidacao(erro));
      }
    });

    return ResponseEntity.badRequest().body(messages);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity tratarErro400(HttpMessageNotReadableException ex) {
    return ResponseEntity.badRequest().body(ex.getMessage());
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity tratarErroValidacao(ConstraintViolationException ex) {

    Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

    List<DadosErroValidacao> messages = new ArrayList<>(constraintViolations.size());

    constraintViolations.forEach(constraintViolation -> {
      // Se houver mais de uma mensagem de erro para o mesmo campo, adiciona a mensagem na lista de mensagens
      if (messages.stream().anyMatch(dadosErroValidacao -> Objects.equals(dadosErroValidacao.field(), constraintViolation.getPropertyPath().toString()))) {
        DadosErroValidacao dados = messages.stream().filter(dadosErroValidacao ->
            Objects.equals(dadosErroValidacao.field(), constraintViolation.getPropertyPath().toString())
        ).findFirst().get();
        messages.remove(dados);

        List<String> mensagens = dados.messages();
        mensagens.add(constraintViolation.getMessage());
        messages.add(new DadosErroValidacao(constraintViolation.getPropertyPath().toString(),
            mensagens));
      }

      messages.add(new DadosErroValidacao(constraintViolation.getPropertyPath().toString(),
          Collections.singletonList(constraintViolation.getMessage())));
    });

    return ResponseEntity.badRequest().body(messages);
  }

//  @ExceptionHandler(BadCredentialsException.class)
//  public ResponseEntity tratarErroBadCredentials() {
//    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
//  }
//
//  @ExceptionHandler(AuthenticationException.class)
//  public ResponseEntity tratarErroAuthentication() {
//    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na autenticação");
//  }
//
//  @ExceptionHandler(AccessDeniedException.class)
//  public ResponseEntity tratarErroAcessoNegado() {
//    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso negado");
//  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity tratarErro500(Exception ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + ex.getLocalizedMessage());
  }

  @ExceptionHandler(JpaSystemException.class)
  public ResponseEntity tratarErro500(JpaSystemException ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + ex.getLocalizedMessage());
  }

  private record DadosErroValidacao(String field, List<String> messages) {
    public DadosErroValidacao(FieldError erro) {
      this(erro.getField(), new ArrayList<>(Collections.singletonList(erro.getDefaultMessage())));
    }
  }

}