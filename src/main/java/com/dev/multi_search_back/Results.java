package com.dev.multi_search_back;

import java.util.List;

public class Results {
  public List<Object> SalesOrders;
  public List<Object> PurchaseOrders;
  public List<Object> Materials;
  public List<Object> Equipments;
  public List<Object> Workforce;

  public Results(List<Object> salesOrders, List<Object> purchaseOrders, List<Object> materials, List<Object> equipments, List<Object> workforce) {
    this.SalesOrders = salesOrders;
    this.PurchaseOrders = purchaseOrders;
    this.Materials = materials;
    this.Equipments = equipments;
    this.Workforce = workforce;
  }
}