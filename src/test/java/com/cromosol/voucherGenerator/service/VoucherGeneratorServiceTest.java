package com.cromosol.voucherGenerator.service;

import com.cromosol.voucherGenerator.BaseTest;
import com.cromosol.voucherGenerator.builder.ItemVoucherBuilder;
import com.cromosol.voucherGenerator.builder.VoucherBuilder;
import com.cromosol.voucherGenerator.entity.ItemVoucher;
import com.cromosol.voucherGenerator.entity.Voucher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;

public class VoucherGeneratorServiceTest extends BaseTest {

  @Autowired
  private VoucherGeneratorService voucherGeneratorService;

  @Test
  public void getPdf_validVoucher_returnsPdf() {

    ItemVoucher itemVoucher = ItemVoucherBuilder.instanceOf()
        .withItemQuantity(3L)
        .withItemArticleId("57/1I")
        .withItemArticleDescription("RETEN OPTICA VW GOL 91/95 E/ARTEB-CIBIE")
        .withItemUnitPrice(new BigDecimal(218.57))
        .withItemTotalAmount(new BigDecimal(655.71))
        .build();

    Voucher voucher = VoucherBuilder.instanceOf()
        .withCompany("CRO")
        .withCustomerId("000015")
        .withBusinessName("Carrin")
        .withCustomerEmail("carrin@cromosol.com")
        .withVatCondition("INSCRIPTO")
        .withVoucherType("NC")
        .withVoucherDate(new Date(119, 03, 21))
        .withBranch(15)
        .withVoucherNumber(97818)
        .withVoucherLetter("A")
        .withFormattedNumber("0015-00097818")
        .withElectronicBill("305007283170600112930793497040820190815")
        .withBarCode("(NÀ7LOÔN1ÂÞ_ìÜPÆê1ÞEÆ)")
        .withItemQuantity(3)
        .withVoucherTotal(new BigDecimal(542.56))
        .withVoucherCode("05")
        .withVoucherTypeAccountId(91)
        .withVoucherDueDate(new Date(119, 03, 21))
        .withCaieType("CAEA")
        .withCaie("28047947832569")
        .withCaieDueDate(new Date(119, 03, 21))
        //.withSubTotal(new BigDecimal(655.71))
        //.withDiscount(new BigDecimal(216.39))
        //.withNetSubTotal(new BigDecimal(439.32))
        .withVatAmount(new BigDecimal(92.26))
        .withGrossIncomePerception(new BigDecimal(10.98))
        .withObservations("NOTA DE CREDITO AUTOMÁTICA PARA EL/LOS RECLAMO/S: 27246")
        .withItems(Collections.singletonList(itemVoucher))
        .build();

    //String pdf = voucherGeneratorService.getPdf(voucher);

    //assertThat(pdf).isNotNull();
  }
}
