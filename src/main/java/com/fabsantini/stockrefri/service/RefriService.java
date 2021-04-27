package com.fabsantini.stockrefri.service;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fabsantini.stockrefri.dto.RefriDTO;
import com.fabsantini.stockrefri.entity.Refri;
import com.fabsantini.stockrefri.exception.RefriAlreadyRegisteredException;
import com.fabsantini.stockrefri.exception.RefriNotFoundException;
import com.fabsantini.stockrefri.exception.RefriStockExceededException;
import com.fabsantini.stockrefri.mapper.RefriMapper;
import com.fabsantini.stockrefri.repository.RefriRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RefriService {

    private final RefriRepository refriRepository;
    private final RefriMapper refriMapper = RefriMapper.INSTANCE;

    public RefriDTO createRefri(RefriDTO refriDTO) throws RefriAlreadyRegisteredException {
        verifyIfIsAlreadyRegistered(refriDTO.getName());
        Refri refri = refriMapper.toModel(refriDTO);
        Refri savedRefri = refriRepository.save(refri);
        return refriMapper.toDTO(savedRefri);
    }

    public RefriDTO findByName(String name) throws RefriNotFoundException {
        Refri foundRefri = refriRepository.findByName(name)
                .orElseThrow(() -> new RefriNotFoundException(name));
        return refriMapper.toDTO(foundRefri);
    }

    public List<RefriDTO> listAll() {
        return refriRepository.findAll()
                .stream()
                .map(refriMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) throws RefriNotFoundException {
        verifyIfExists(id);
        refriRepository.deleteById(id);
    }

    private void verifyIfIsAlreadyRegistered(String name) throws RefriAlreadyRegisteredException {
        Optional<Refri> optSavedBeer = refriRepository.findByName(name);
        if (optSavedBeer.isPresent()) {
            throw new RefriAlreadyRegisteredException(name);
        }
    }

    private Refri verifyIfExists(Long id) throws RefriNotFoundException {
        return refriRepository.findById(id)
                .orElseThrow(() -> new RefriNotFoundException(id));
    }

    public RefriDTO increment(Long id, int quantityToIncrement) throws RefriNotFoundException, RefriStockExceededException {
        Refri refriToIncrementStock = verifyIfExists(id);
        int quantityAfterIncrement = quantityToIncrement + refriToIncrementStock.getQuantity();
        if (quantityAfterIncrement <= refriToIncrementStock.getMax()) {
            refriToIncrementStock.setQuantity(refriToIncrementStock.getQuantity() + quantityToIncrement);
            Refri incrementedRefriStock = refriRepository.save(refriToIncrementStock);
            return refriMapper.toDTO(incrementedRefriStock);
        }
        throw new RefriStockExceededException(id, quantityToIncrement);
    }
}
}
