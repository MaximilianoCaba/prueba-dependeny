package com.cromosol.voucherGenerator.enums;

public enum CompanyEnum {
  CRO(1, "Cromosol", "CRO", "Cromosol S.A.", "30-50072831-7", "cb051474-e05b-4087-a305-808e41c18e6a", "test@comprobantes.cromosol.com"),
  BBA(2, "BBA", "BBA", "BBA Autopartes S.A.", "30-71128531-4", "c25d1b0e-295a-4431-b41d-e2ce0d42e04e", "test@comprobantes.bbaautopartes.com");

  private final int code;
  private final String name;
  private final String abbreviation;
  private final String businessName;
  private final String cuit;
  private final String apiKey;
  private final String emailAddress;

  CompanyEnum(int code, String name, String abbreviation, String businessName, String cuit, String apiKey, String emailAddress) {
    this.code = code;
    this.name = name;
    this.abbreviation = abbreviation;
    this.businessName = businessName;
    this.cuit = cuit;
    this.apiKey = apiKey;
    this.emailAddress = emailAddress;
  }

  public int getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public String getAbbreviation() {
    return abbreviation;
  }

  public String getBusinessName() {
    return businessName;
  }

  public String getCuit() {
    return cuit;
  }

  public String getApiKey() {
    return apiKey;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public static String getNameByCode(int code) {
    return getByCode(code).getName();
  }

  public static CompanyEnum getByCode(int code) {
    for (CompanyEnum company : values()) {
      if (company.getCode() == code)
        return company;
    }
    throw new IllegalArgumentException("The company with code " + code + " dose not exist");
  }
}
