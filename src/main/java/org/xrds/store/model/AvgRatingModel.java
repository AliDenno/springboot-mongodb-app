package org.xrds.store.model;

/*
 - Create aggregation
 - Define a class model for the projection (AvgRatingModel)
 - Build projection using MongoTemplate class
 - Execute the projection and convert to AvgRatingModel
 */
public class AvgRatingModel {
    private String id;
    private String productName;
    private double avgRating;

    public double getAvgRating() {
        return avgRating;
    }

    public String getProductName() {
        return productName;
    }

    public String getId() {
        return id;
    }
}
