package com.iot.smarttracker.dynamoDb

import android.util.Log
import com.amazonaws.mobile.client.AWSMobileClient
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import com.iot.smarttracker.amazonaws.models.nosql.UserTableDO
import com.iot.smarttracker.util.Constants

class Usertable {
    private val LOG_TAG = Usertable::class.java.simpleName
    private var dynamoDBMapper: DynamoDBMapper? = null

    fun insertUser(userId: String, userName: String?, email: String?) {
        try {
            val dynamoDBClient = AmazonDynamoDBClient(AWSMobileClient.getInstance().credentialsProvider)
            this.dynamoDBMapper = DynamoDBMapper.builder()
                    .dynamoDBClient(dynamoDBClient)
                    .awsConfiguration(AWSMobileClient.getInstance().configuration)
                    .build()
            Thread(Runnable {
                val userTableDO = UserTableDO()
                userTableDO.id = userId

                if (userName != null) userTableDO.name = userName

                Thread(Runnable { dynamoDBMapper?.save<UserTableDO>(userTableDO) }).start()
            }).start()
        } catch (e: Exception) {
            Log.e(LOG_TAG, "Error : $e")
        }
    }

    fun isUserAlreadyRegistered(id: String): Boolean {
        return try {
            val dynamoDBClient = AmazonDynamoDBClient(AWSMobileClient.getInstance().credentialsProvider)
            this.dynamoDBMapper = DynamoDBMapper.builder()
                    .dynamoDBClient(dynamoDBClient)
                    .awsConfiguration(AWSMobileClient.getInstance().configuration)
                    .build()

            val checkUser = dynamoDBMapper?.load(UserTableDO::class.java, id)
            checkUser != null
        } catch (e: Exception) {
            Log.e(LOG_TAG, "Error: $e")
            false
        }

    }

    fun updateLocation(location: String, userId: String) {
        try {
            val dynamoDBClient = AmazonDynamoDBClient(AWSMobileClient.getInstance().credentialsProvider)
            this.dynamoDBMapper = DynamoDBMapper.builder()
                    .dynamoDBClient(dynamoDBClient)
                    .awsConfiguration(AWSMobileClient.getInstance().configuration)
                    .build()

            var updateLocation = UserTableDO()
            Thread(Runnable {
                updateLocation = dynamoDBMapper?.load(UserTableDO::class.java, userId)!!
                updateLocation.point = location
                dynamoDBMapper?.save<UserTableDO>(updateLocation)
            }).start()

        } catch (e: Exception) {
            Log.e(LOG_TAG, "Error : $e")
        }
    }
}