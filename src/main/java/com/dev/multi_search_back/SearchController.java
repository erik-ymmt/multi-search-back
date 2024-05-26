package com.dev.multi_search_back;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class SearchController {

	@CrossOrigin
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
							List<Map<String, Object>> fileResults = mapper.readValue(file, new TypeReference<>() {});
							for (Map<String, Object> result : fileResults) {
									for (Object value : result.values()) {
										if (value.toString().toLowerCase().contains(searchTerm.toLowerCase())) {
											switch (file.getName()) {
												case "equipments.json":
													equipments.add(result);
													resultCount++;
													break;
												case "materials.json":
													materials.add(result);
													resultCount++;
													break;
												case "purchase_orders.json":
													purchaseOrders.add(result);
													resultCount++;
													break;
												case "sales_orders.json":
													salesOrders.add(result);
													resultCount++;
													break;
												case "workforce.json":
													workforce.add(result);
													resultCount++;
													break;
											}
											break;
										}
								}
							}
					}
				}

				Results allResults = new Results(salesOrders, purchaseOrders, materials, equipments, workforce);
				SearchData searchResult = new SearchData(resultCount, allResults);
				System.out.println(resultCount);
				return searchResult;
		} catch (IOException e) {
				System.err.println("Error: " + e.getMessage());
				return new SearchData();
		}
	}
}