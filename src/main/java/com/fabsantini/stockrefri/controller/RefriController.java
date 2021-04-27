package com.fabsantini.stockrefri.controller;

import com.fabsantini.stockrefri.service.RefriService;
import lombok.AllArgsConstructor;
import com.fabsantini.stockrefri.dto.RefriDTO;
import com.fabsantini.stockrefri.dto.QuantityDTO;
import com.fabsantini.stockrefri.exception.RefriAlreadyRegisteredException;
import com.fabsantini.stockrefri.exception.RefriNotFoundException;
import com.fabsantini.stockrefri.exception.RefriStockExceededException;
import com.fabsantini.stockrefri.service.RefriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/refris")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RefriController implements RefriControllerDocs {

    private final RefriService refriService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RefriDTO createRefri(@RequestBody @Valid RefriDTO refriDTO) throws RefriAlreadyRegisteredException {
        return refriService.createRefri(refriDTO);
    }

    @GetMapping("/{name}")
    public RefriDTO findByName(@PathVariable String name) throws RefriNotFoundException {
        return refriService.findByName(name);
    }

    @GetMapping
    public List<RefriDTO> listRefris() {
        return refriService.listAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws RefriNotFoundException {
        refriService.deleteById(id);
    }

    @PatchMapping("/{id}/increment")
    public RefriDTO increment(@PathVariable Long id, @RequestBody @Valid QuantityDTO quantityDTO) throws RefriNotFoundException, RefriStockExceededException {
        return refriService.increment(id, quantityDTO.getQuantity());
    }
}
