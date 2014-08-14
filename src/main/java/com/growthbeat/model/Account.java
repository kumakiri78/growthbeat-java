package com.growthbeat.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.growthbeat.Context;

public class Account extends Model {

	private String id;
	private String name;
	private PlanGrade planGrade;
	private Date created;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated() {
		return created;
	}

	public PlanGrade getPlanGrade() {
		return planGrade;
	}

	public void setPlanGrade(PlanGrade planGrade) {
		this.planGrade = planGrade;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public static Account findById(String id, Context context) {
		return get(context, String.format("1/accounts/%s", id), new HashMap<String, Object>(), Account.class);
	}

	public static Account create(String name, Context context) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		return post(context, "1/accounts", params, Account.class);
	}

	public static void deleteById(String id, Context context) {
		delete(context, String.format("1/accounts/%s", id), new HashMap<String, Object>(), Void.class);
	}

	public enum PlanGrade {
		micro, small, medium, large, extra
	}

}
