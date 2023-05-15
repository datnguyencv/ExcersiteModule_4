package com.example.bookmanagement.service.impl;

import com.example.bookmanagement.model.Borrower;
import com.example.bookmanagement.repository.IBorrowerRepository;
import com.example.bookmanagement.service.IBorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowerService implements IBorrowerService {
    @Autowired
    IBorrowerRepository borrowerRepository;
    @Override
    public List<Borrower> findAllBorrower() {
        return borrowerRepository.findAll();
    }

    @Override
    public String setCodeBorrower() {
        String codeCheck;
        List<Borrower> borrowers = new ArrayList<>();
        do {
            codeCheck = String.format("%05d", (int) (Math.random() * 100000));
            boolean isDuplicate = false;
            for (Borrower borrower : borrowers) {
                if (borrower.getCode().equals(codeCheck)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                break;
            }
        } while (true);
        return codeCheck;
    }
}
