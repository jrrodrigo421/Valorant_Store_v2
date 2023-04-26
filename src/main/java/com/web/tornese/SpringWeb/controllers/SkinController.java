package com.web.tornese.SpringWeb.controllers;

import java.util.List;
import java.util.Optional;

// import com.web.tornese.SpringWeb.models.Administrador;
import com.web.tornese.SpringWeb.models.Skin;
// import com.web.tornese.SpringWeb.repositorio.AdministradoresRepo;
import com.web.tornese.SpringWeb.repositorio.SkinRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SkinController {

  @Autowired
  private SkinRepo repo;

  @GetMapping("/skin")
  public String index(Model model) {
    List<Skin> skin = (List<Skin>) repo.findAll();
    model.addAttribute("skin", skin);
    return "skin/index";
  }

  @GetMapping("/skin/novo")
  public String novo() {
    return "skin/novo";
  }

  @PostMapping("/skin/criar")
  public String criar(Skin skin) {
    repo.save(skin);
    return "redirect:/skin";
  }

  @GetMapping("/skin/{id}")
  public String busca(@PathVariable int id, Model model) {
    Optional<Skin> skinedit = repo.findById(id);
    try {
      model.addAttribute("skin", skinedit.get());
    } catch (Exception err) {
      return "redirect:/skin";
    }

    return "/skin/editar";
  }

  @PostMapping("/skin/{id}/atualizar")
  public String atualizar(@PathVariable int id, Skin skin) {
    // if(!repo.exist(id)){
    if (!repo.existsById(id)) {
      return "redirect:/skin";
    }

    repo.save(skin);

    return "redirect:/skin";
  }

  @GetMapping("/skin/{id}/excluir")
  public String excluir(@PathVariable int id) {
    repo.deleteById(id);
    return "redirect:/skin";
  }
}
