package com.dev.multi_search_back;

public class SearchData {
  public Integer resultsCount;
  public Results results;

  public SearchData() {
    this.resultsCount = 0;
  }
  public SearchData(Integer resultsCount, Results results) {
    this.resultsCount = resultsCount;
    this.results = results;
  }
}

