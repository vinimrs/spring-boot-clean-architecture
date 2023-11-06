package br.ufscar.dc.dsw.bikerental.infrastructure.config.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class AcceptHeaderResolver extends AcceptHeaderLocaleResolver {

  List<Locale> LOCALES = Arrays.asList(new Locale("en"), new Locale("pt-BR"));

  @Override
  public Locale resolveLocale(HttpServletRequest request) {
    String headerLang = request.getHeader("Accept-Language");
    return headerLang == null || headerLang.isEmpty()
        ? Locale.getDefault()
        : Locale.lookup(Locale.LanguageRange.parse(headerLang), LOCALES);
  }


}