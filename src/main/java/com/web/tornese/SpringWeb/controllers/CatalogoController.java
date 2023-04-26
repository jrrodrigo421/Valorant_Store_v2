package com.web.tornese.SpringWeb.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class CatalogoController {

  @GetMapping("/catalogo")
  public String catalogo() {
    return "catalogo/index";
  }

}
