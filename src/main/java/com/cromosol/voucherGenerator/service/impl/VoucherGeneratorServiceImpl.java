package com.cromosol.voucherGenerator.service.impl;

import com.cromosol.voucherGenerator.entity.Voucher;
import com.cromosol.voucherGenerator.entity.VoucherPage;
import com.cromosol.voucherGenerator.enums.CompanyEnum;
import com.cromosol.voucherGenerator.exception.PDFCreationException;
import com.cromosol.voucherGenerator.service.VoucherGeneratorService;
import com.cromosol.voucherGenerator.util.PdfCreationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VoucherGeneratorServiceImpl implements VoucherGeneratorService {

  private final PdfCreationUtil pdfCreationUtil;

  private static final Long AVELLANEDA_BRANCH = 14L;
  private static final String XSL_EXTENSION = ".xsl";

  @Override
  public String getPdf(List<VoucherPage> voucherPages) throws PDFCreationException {
    Voucher voucher = voucherPages.get(0).getVoucher();
    String voucherCompany = voucher.getCompany();
    boolean isAve = voucher.getSucursal() == AVELLANEDA_BRANCH
        && !voucherCompany.equals(CompanyEnum.CRO.getAbbreviation());
    String templatePath =
        "static" +
            File.separator + "static/comprobantes" +
            File.separator + "template-" +
            voucher.getVoucherType() + "-" + (isAve ? "AVE" : voucherCompany) +
            XSL_EXTENSION;
    byte[] content = pdfCreationUtil.generateFile(this.getClass().getClassLoader().getResourceAsStream(templatePath), voucherPages);
    return Base64.getEncoder().encodeToString(content);
  }
}
