package com.cromosol.voucherGenerator.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
public class Voucher {

  private String company;
  private String customerId;
  private String businessName;
  private String customerEmail;
  private String vatCondition;
  private String voucherType;
  private Date voucherDate;
  private int sucursal;
  private int voucherNumber;
  private String voucherLetter;
  private String formattedNumber;
  private String electronicBill;
  private String barCode;
  private int itemQuantity;
  private BigDecimal voucherTotal;
  private String voucherCode;
  private int ctaCteTipoComprobanteID;
  private Date voucherDueDate;
  private String CAIEType;
  private String caie;
  private Date CAIEDueDate;
  private Long subTotal;
  private Long discount;
  private Long netSubTotal;
  private BigDecimal vatAmount;
  private BigDecimal grossIncomePerception;
  private String includedOrders;
  private String expeditions;
  private String observations;
  private String cuit;
  private String address;
  private String state;
  private String city;
  private String sellerCode;
  private String expirationDate;
  private String jurisdiction;

  private List<ItemVoucher> items;

  public String getExpirationDate() {
    SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
    return formater.format(this.getCAIEDueDate());
  }

  public String getVoucherDate() {
    SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
    return formater.format(this.voucherDate);
  }
}
