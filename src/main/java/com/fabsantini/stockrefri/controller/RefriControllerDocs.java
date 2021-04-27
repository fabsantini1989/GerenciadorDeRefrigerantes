package com.fabsantini.stockrefri.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

@Api("Manages refri stock")
public class RefriControllerDocs {

    @ApiOperation(value = "Refrigerant creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success refrigerant creation"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
    })
    RefriDTO createRefri(RefriDTO refriDTO) throws RefriAlreadyRegisteredException;

    @ApiOperation(value = "Returns refri found by a given name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success refri found in the system"),
            @ApiResponse(code = 404, message = "Refri with given name not found.")
    })
    RefriDTO findByName(@PathVariable String name) throws RefriNotFoundException;

    @ApiOperation(value = "Returns a list of all refrigerants registered in the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all refrigerants registered in the system"),
    })
    List<RefriDTO> listRefris();

    @ApiOperation(value = "Delete a refri found by a given valid Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success beer deleted in the system"),
            @ApiResponse(code = 404, message = "Refri with given id not found.")
    })
    void deleteById(@PathVariable Long id) throws RefriNotFoundException;
}
