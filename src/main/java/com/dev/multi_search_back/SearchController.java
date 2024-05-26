package com.dev.multi_search_back;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class SearchController {
	@GetMapping("/search")
	public SearchData search(@RequestParam(value = "q") String searchTerm) {
		ObjectMapper mapper = new ObjectMapper();
		try {
				File directory = new File("src/main/java/com/dev/multi_search_back/data");
				File[] files = directory.listFiles();
				List<Object> equipments = new ArrayList<>();
				List<Object> materials = new ArrayList<>();
				List<Object> purchaseOrders = new ArrayList<>();
				List<Object> salesOrders = new ArrayList<>();
				List<Object> workforce = new ArrayList<>();
				Integer resultCount = 0;

				if (files != null) {
					for (File file : files) {
							List<Object> fileResults = mapper.readValue(file, new TypeReference<List<Object>>() {});
							for (Object result : fileResults) {
									if (!(result instanceof Map)) continue;
									Map<String, Object> resultMap = (Map<String, Object>) result;
									for (Object value : resultMap.values()) {
										if (value.toString().toLowerCase().contains(searchTerm.toLowerCase())) {
												// System.out.println(value);
												// System.out.println(file.getName());
												if ("equipments.json".equals(file.getName())) {
													equipments.add(resultMap);
													resultCount++;
													break;
												}
												if ("materials.json".equals(file.getName())) {
													materials.add(resultMap);
													resultCount++;
													break;
												}
												if ("purchase_orders.json".equals(file.getName())) {
													purchaseOrders.add(resultMap);
													resultCount++;
													break;
												}
												if ("sales_orders.json".equals(file.getName())) {
													salesOrders.add(resultMap);
													resultCount++;
													break;
												}
												if ("workforce.json".equals(file.getName())) {
													workforce.add(resultMap);
													resultCount++;
													break;
												}
										}
								}
							}
					}
				}

				Results allResults = new Results(salesOrders, purchaseOrders, materials, equipments, workforce);
				SearchData searchResult = new SearchData(resultCount, allResults);
				return searchResult;
		} catch (IOException e) {
				System.err.println("Error: " + e.getMessage());
				SearchData searchResult = new SearchData();
				return searchResult;
		}
	}
}