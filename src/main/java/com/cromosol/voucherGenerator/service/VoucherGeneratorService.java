package com.cromosol.voucherGenerator.service;


import com.cromosol.voucherGenerator.entity.VoucherPage;
import com.cromosol.voucherGenerator.exception.PDFCreationException;

import java.util.List;

public interface VoucherGeneratorService {

  String getPdf(List<VoucherPage> voucherPage) throws PDFCreationException;

}