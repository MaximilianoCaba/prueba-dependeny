package com.cromosol.voucherGenerator.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VoucherPage {

  Voucher voucher;
  ItemVoucher[] items;
  BigDecimal pageSubTotal;
  BigDecimal previousPageSubTotal;
  boolean lastPage;

}
