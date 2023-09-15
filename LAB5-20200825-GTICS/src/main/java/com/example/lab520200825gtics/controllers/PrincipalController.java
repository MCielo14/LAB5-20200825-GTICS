package com.example.lab520200825gtics.controllers;

import com.example.lab520200825gtics.entidades.Viaje;
import com.example.lab520200825gtics.repositorios.LugaresRepository;
import com.example.lab520200825gtics.repositorios.PersonaRepository;
import com.example.lab520200825gtics.repositorios.ViajeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
public class PrincipalController {
    final ViajeRepository viajeRepository;
    final LugaresRepository lugaresRepository;
    final PersonaRepository personaRepository;
    public PrincipalController(ViajeRepository viajeRepository,LugaresRepository lugaresRepository,PersonaRepository personaRepository) {
        this.viajeRepository = viajeRepository;
        this.lugaresRepository=lugaresRepository;
        this.personaRepository=personaRepository;

    }
    @GetMapping("/inicio")
    public String lista() {
    return "principal";
}
    @GetMapping("/viajes")
    public String viajes(Model model) {
        List<Viaje> listaviajes = viajeRepository.findAll();
        model.addAttribute("listaviajes", listaviajes);

        return "viajes";
    }
    @GetMapping("/mascotas")
    public String mascotas() {
        return "mascotas";
    }
    @GetMapping("/lugares")
    public String lugares() {
        return "lugares";
    }
    @GetMapping("/nuevamascota")
    public String nuevamascota() {
        return "nuevamascota";
    }
    @GetMapping("/editarviaje")
    public String editarviaje(Model model,
                                 @RequestParam("id") int id) {

        Optional<Viaje> optional = viajeRepository.findById(id);
        if (optional.isPresent()) {
            Viaje viaje = optional.get();
            model.addAttribute("viaje", viaje);
            model.addAttribute("listapersona",personaRepository.findAll());
            model.addAttribute("listalugares",lugaresRepository.findAll());
            return "editFormViajes";
        } else {
            return "redirect:/viajes";
        }
    }
    @GetMapping("/borrarviaje")
    public String borrarTransportista(Model model,
                                      @RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Viaje> optShipper = viajeRepository.findById(id);

        if (optShipper.isPresent()) {
            viajeRepository.deleteById(id);
        }
        return "redirect:/viajes";

    }


    @GetMapping("/nuevoviaje")
    public String nuevoviaje(Model model) {
        Random numAleatorio = new Random();
        int n = numAleatorio.nextInt(75-25+1) + 25;
        model.addAttribute("numero",n);
        model.addAttribute("listapersona",personaRepository.findAll());
        model.addAttribute("listalugares",lugaresRepository.findAll());
        return "nuevoviaje";
    }
    @PostMapping("/saveviaje")
    public String saveviaje(Viaje viaje, RedirectAttributes attr) {
        viajeRepository.save(viaje);
        return "redirect:/viajes";
    }


}
