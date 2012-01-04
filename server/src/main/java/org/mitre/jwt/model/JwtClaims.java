package org.mitre.jwt.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class JwtClaims extends ClaimSet {
	
	public static final String TYPE = "typ";
	public static final String JWT_ID = "jti";
	public static final String PRINCIPAL = "prn";
	public static final String AUDIENCE = "aud";
	public static final String ISSUER = "iss";
	public static final String ISSUED_AT = "iat";
	public static final String NOT_BEFORE = "nbf";
	public static final String EXPIRATION = "exp";

	/**
	 * ISO8601 / RFC3339 Date Format
	 */
	//public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");

	public JwtClaims() {
		
	}
	
	public JwtClaims(JsonObject json) {
		for (Entry<String, JsonElement> element : json.entrySet()) {
	        if (element.getKey().equals(EXPIRATION)) {
                setExpiration(new Date(element.getValue().getAsLong() * 1000L));
	        } else if (element.getKey().equals(NOT_BEFORE)) {
                setNotBefore(new Date(element.getValue().getAsLong() * 1000L));
	        } else if (element.getKey().equals(ISSUED_AT)) {	        	
                setIssuedAt(new Date(element.getValue().getAsLong() * 1000L));
	        } else if (element.getKey().equals(ISSUER)) {	        	
	        	setIssuer(element.getValue().getAsString());
	        } else if (element.getKey().equals(AUDIENCE)) {	        	
	        	setAudience(element.getValue().getAsString());
	        } else if (element.getKey().equals(PRINCIPAL)) {	        	
	        	setPrincipal(element.getValue().getAsString());
	        } else if (element.getKey().equals(JWT_ID)) {	        	
	        	setJwtId(element.getValue().getAsString());
	        } else if (element.getKey().equals(TYPE)) {	        	
	        	setType(element.getValue().getAsString());
	        } else {
	        	if (element.getValue().isJsonPrimitive()){
		        	// we handle all primitives in here
		        	JsonPrimitive prim = element.getValue().getAsJsonPrimitive();
		        	setClaim(element.getKey(), prim);
		        } else {
		        	setClaim(element.getKey(), element.getValue());
		        }
	        }
        }
    }

	/**
     * @return the expiration
     */
    public Date getExpiration() {
    	return getClaimAsDate(EXPIRATION);
    }

	/**
     * @param expiration the expiration to set
     */
    public void setExpiration(Date expiration) {
    	setClaim(EXPIRATION, expiration);
    }

	/**
     * @return the notBefore
     */
    public Date getNotBefore() {
    	return getClaimAsDate(NOT_BEFORE);
    }

	/**
     * @param notBefore the notBefore to set
     */
    public void setNotBefore(Date notBefore) {
    	setClaim(NOT_BEFORE, notBefore);
    }

	/**
     * @return the issuedAt
     */
    public Date getIssuedAt() {
    	return getClaimAsDate(ISSUED_AT);
    }

	/**
     * @param issuedAt the issuedAt to set
     */
    public void setIssuedAt(Date issuedAt) {
    	setClaim(ISSUED_AT, issuedAt);
    }

	/**
     * @return the issuer
     */
    public String getIssuer() {
    	return getClaimAsString(ISSUER);
    }

	/**
     * @param issuer the issuer to set
     */
    public void setIssuer(String issuer) {
    	setClaim(ISSUER, issuer);
    }

	/**
     * @return the audience
     */
    public String getAudience() {
    	return getClaimAsString(AUDIENCE);
    }

	/**
     * @param audience the audience to set
     */
    public void setAudience(String audience) {
    	setClaim(AUDIENCE, audience);
    }

	/**
     * @return the principal
     */
    public String getPrincipal() {
    	return getClaimAsString(PRINCIPAL);
    }

	/**
     * @param principal the principal to set
     */
    public void setPrincipal(String principal) {
    	setClaim(AUDIENCE, principal);
    }

	/**
     * @return the jwtId
     */
    public String getJwtId() {
    	return getClaimAsString(JWT_ID);
    }

	/**
     * @param jwtId the jwtId to set
     */
    public void setJwtId(String jwtId) {
    	setClaim(JWT_ID, jwtId);
    }

	/**
     * @return the type
     */
    public String getType() {
    	return getClaimAsString(TYPE);
    }

	/**
     * @param type the type to set
     */
    public void setType(String type) {
    	setClaim(TYPE, type);
    }
    

}
