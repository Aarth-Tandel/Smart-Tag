package com.iot.smarttracker.amazonaws.models.nosql;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.util.List;
import java.util.Map;
import java.util.Set;

@DynamoDBTable(tableName = "smarttracker-mobilehub-678738335-UserTable")

public class UserTableDO {
    private String _iD;
    private String _clusters;
    private String _deviceId;
    private String _name;
    private String _point;

    @DynamoDBHashKey(attributeName = "ID")
    @DynamoDBAttribute(attributeName = "ID")
    public String getID() {
        return _iD;
    }

    public void setID(final String _iD) {
        this._iD = _iD;
    }
    @DynamoDBAttribute(attributeName = "Clusters")
    public String getClusters() {
        return _clusters;
    }

    public void setClusters(final String _clusters) {
        this._clusters = _clusters;
    }
    @DynamoDBAttribute(attributeName = "DeviceId")
    public String getDeviceId() {
        return _deviceId;
    }

    public void setDeviceId(final String _deviceId) {
        this._deviceId = _deviceId;
    }
    @DynamoDBAttribute(attributeName = "Name")
    public String getName() {
        return _name;
    }

    public void setName(final String _name) {
        this._name = _name;
    }
    @DynamoDBAttribute(attributeName = "Point")
    public String getPoint() {
        return _point;
    }

    public void setPoint(final String _point) {
        this._point = _point;
    }

}
