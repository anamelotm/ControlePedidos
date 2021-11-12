package com.br.chocolatePontoVirgula.controller;


import com.br.chocolatePontoVirgula.model.entity.ItemPedido;
import com.br.chocolatePontoVirgula.model.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/itens-pedidos")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @PostMapping
    public void save(@RequestBody ItemPedido itemPedido){
        itemPedidoService.save(itemPedido);
    }

//    @PutMapping("/{id}")
//    public void update(@PathVariable Long id, @RequestBody ItemPedido itemPedido){
//        itemPedidoService.update(id, itemPedido);
//    } REVISAR ESSE MÉTODO

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        itemPedidoService.excluir(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> findById(@PathVariable Long id) {
        return itemPedidoService.findById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<ItemPedido>> findAll(Pageable pageable) {
        return itemPedidoService.findAll(pageable);
    }

}