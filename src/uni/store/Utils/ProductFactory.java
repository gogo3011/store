package uni.store.Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import uni.store.Entities.Product;
import uni.store.Entities.ProductType;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TimeZone;

public class ProductFactory {
    private ProductFactory(){}

    public static ArrayList<Product> generateProductsFromJSON() {
        ArrayList<Product> products = new ArrayList<>();
        JSONObject jsonObject = FileHelper.getJsonContents(
                "src/resources/products.json"
        );
        JSONArray jsonArray = (JSONArray) jsonObject.get("products");
        jsonArray.forEach((pr) -> products.add(createProduct((JSONObject) pr)));
        return products;
    }

    public static Product createProduct(JSONObject obj) {
        return new Product(Math.toIntExact((Long) obj.get("id")),
                (String) obj.get("name"),
                (Double) obj.get("pricePerPs"),
                (Long) obj.get("qty"),
                ProductType.valueOf((String) obj.get("productType")),
                LocalDate.ofInstant(Instant.ofEpochMilli((Long) obj.get("expireDate")*1000), TimeZone.getDefault().toZoneId()));
    }

}
