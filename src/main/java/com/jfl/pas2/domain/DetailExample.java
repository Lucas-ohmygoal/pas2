package com.jfl.pas2.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DetailExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table detail
     *
     * @mbggenerated Wed Aug 11 21:50:55 CST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table detail
     *
     * @mbggenerated Wed Aug 11 21:50:55 CST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table detail
     *
     * @mbggenerated Wed Aug 11 21:50:55 CST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table detail
     *
     * @mbggenerated Wed Aug 11 21:50:55 CST 2021
     */
    public DetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table detail
     *
     * @mbggenerated Wed Aug 11 21:50:55 CST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table detail
     *
     * @mbggenerated Wed Aug 11 21:50:55 CST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table detail
     *
     * @mbggenerated Wed Aug 11 21:50:55 CST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table detail
     *
     * @mbggenerated Wed Aug 11 21:50:55 CST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table detail
     *
     * @mbggenerated Wed Aug 11 21:50:55 CST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table detail
     *
     * @mbggenerated Wed Aug 11 21:50:55 CST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table detail
     *
     * @mbggenerated Wed Aug 11 21:50:55 CST 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table detail
     *
     * @mbggenerated Wed Aug 11 21:50:55 CST 2021
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table detail
     *
     * @mbggenerated Wed Aug 11 21:50:55 CST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table detail
     *
     * @mbggenerated Wed Aug 11 21:50:55 CST 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table detail
     *
     * @mbggenerated Wed Aug 11 21:50:55 CST 2021
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberEqualTo(String value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(String value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(String value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(String value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLike(String value) {
            addCriterion("serial_number like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotLike(String value) {
            addCriterion("serial_number not like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<String> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<String> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(String value1, String value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(String value1, String value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("product_id like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("product_id not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductNumberIsNull() {
            addCriterion("product_number is null");
            return (Criteria) this;
        }

        public Criteria andProductNumberIsNotNull() {
            addCriterion("product_number is not null");
            return (Criteria) this;
        }

        public Criteria andProductNumberEqualTo(BigDecimal value) {
            addCriterion("product_number =", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotEqualTo(BigDecimal value) {
            addCriterion("product_number <>", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberGreaterThan(BigDecimal value) {
            addCriterion("product_number >", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_number >=", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberLessThan(BigDecimal value) {
            addCriterion("product_number <", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_number <=", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberIn(List<BigDecimal> values) {
            addCriterion("product_number in", values, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotIn(List<BigDecimal> values) {
            addCriterion("product_number not in", values, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_number between", value1, value2, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_number not between", value1, value2, "productNumber");
            return (Criteria) this;
        }

        public Criteria andWithCupsIsNull() {
            addCriterion("with_cups is null");
            return (Criteria) this;
        }

        public Criteria andWithCupsIsNotNull() {
            addCriterion("with_cups is not null");
            return (Criteria) this;
        }

        public Criteria andWithCupsEqualTo(String value) {
            addCriterion("with_cups =", value, "withCups");
            return (Criteria) this;
        }

        public Criteria andWithCupsNotEqualTo(String value) {
            addCriterion("with_cups <>", value, "withCups");
            return (Criteria) this;
        }

        public Criteria andWithCupsGreaterThan(String value) {
            addCriterion("with_cups >", value, "withCups");
            return (Criteria) this;
        }

        public Criteria andWithCupsGreaterThanOrEqualTo(String value) {
            addCriterion("with_cups >=", value, "withCups");
            return (Criteria) this;
        }

        public Criteria andWithCupsLessThan(String value) {
            addCriterion("with_cups <", value, "withCups");
            return (Criteria) this;
        }

        public Criteria andWithCupsLessThanOrEqualTo(String value) {
            addCriterion("with_cups <=", value, "withCups");
            return (Criteria) this;
        }

        public Criteria andWithCupsLike(String value) {
            addCriterion("with_cups like", value, "withCups");
            return (Criteria) this;
        }

        public Criteria andWithCupsNotLike(String value) {
            addCriterion("with_cups not like", value, "withCups");
            return (Criteria) this;
        }

        public Criteria andWithCupsIn(List<String> values) {
            addCriterion("with_cups in", values, "withCups");
            return (Criteria) this;
        }

        public Criteria andWithCupsNotIn(List<String> values) {
            addCriterion("with_cups not in", values, "withCups");
            return (Criteria) this;
        }

        public Criteria andWithCupsBetween(String value1, String value2) {
            addCriterion("with_cups between", value1, value2, "withCups");
            return (Criteria) this;
        }

        public Criteria andWithCupsNotBetween(String value1, String value2) {
            addCriterion("with_cups not between", value1, value2, "withCups");
            return (Criteria) this;
        }

        public Criteria andWithCirclesIsNull() {
            addCriterion("with_circles is null");
            return (Criteria) this;
        }

        public Criteria andWithCirclesIsNotNull() {
            addCriterion("with_circles is not null");
            return (Criteria) this;
        }

        public Criteria andWithCirclesEqualTo(String value) {
            addCriterion("with_circles =", value, "withCircles");
            return (Criteria) this;
        }

        public Criteria andWithCirclesNotEqualTo(String value) {
            addCriterion("with_circles <>", value, "withCircles");
            return (Criteria) this;
        }

        public Criteria andWithCirclesGreaterThan(String value) {
            addCriterion("with_circles >", value, "withCircles");
            return (Criteria) this;
        }

        public Criteria andWithCirclesGreaterThanOrEqualTo(String value) {
            addCriterion("with_circles >=", value, "withCircles");
            return (Criteria) this;
        }

        public Criteria andWithCirclesLessThan(String value) {
            addCriterion("with_circles <", value, "withCircles");
            return (Criteria) this;
        }

        public Criteria andWithCirclesLessThanOrEqualTo(String value) {
            addCriterion("with_circles <=", value, "withCircles");
            return (Criteria) this;
        }

        public Criteria andWithCirclesLike(String value) {
            addCriterion("with_circles like", value, "withCircles");
            return (Criteria) this;
        }

        public Criteria andWithCirclesNotLike(String value) {
            addCriterion("with_circles not like", value, "withCircles");
            return (Criteria) this;
        }

        public Criteria andWithCirclesIn(List<String> values) {
            addCriterion("with_circles in", values, "withCircles");
            return (Criteria) this;
        }

        public Criteria andWithCirclesNotIn(List<String> values) {
            addCriterion("with_circles not in", values, "withCircles");
            return (Criteria) this;
        }

        public Criteria andWithCirclesBetween(String value1, String value2) {
            addCriterion("with_circles between", value1, value2, "withCircles");
            return (Criteria) this;
        }

        public Criteria andWithCirclesNotBetween(String value1, String value2) {
            addCriterion("with_circles not between", value1, value2, "withCircles");
            return (Criteria) this;
        }

        public Criteria andWithSwitchesIsNull() {
            addCriterion("with_switches is null");
            return (Criteria) this;
        }

        public Criteria andWithSwitchesIsNotNull() {
            addCriterion("with_switches is not null");
            return (Criteria) this;
        }

        public Criteria andWithSwitchesEqualTo(String value) {
            addCriterion("with_switches =", value, "withSwitches");
            return (Criteria) this;
        }

        public Criteria andWithSwitchesNotEqualTo(String value) {
            addCriterion("with_switches <>", value, "withSwitches");
            return (Criteria) this;
        }

        public Criteria andWithSwitchesGreaterThan(String value) {
            addCriterion("with_switches >", value, "withSwitches");
            return (Criteria) this;
        }

        public Criteria andWithSwitchesGreaterThanOrEqualTo(String value) {
            addCriterion("with_switches >=", value, "withSwitches");
            return (Criteria) this;
        }

        public Criteria andWithSwitchesLessThan(String value) {
            addCriterion("with_switches <", value, "withSwitches");
            return (Criteria) this;
        }

        public Criteria andWithSwitchesLessThanOrEqualTo(String value) {
            addCriterion("with_switches <=", value, "withSwitches");
            return (Criteria) this;
        }

        public Criteria andWithSwitchesLike(String value) {
            addCriterion("with_switches like", value, "withSwitches");
            return (Criteria) this;
        }

        public Criteria andWithSwitchesNotLike(String value) {
            addCriterion("with_switches not like", value, "withSwitches");
            return (Criteria) this;
        }

        public Criteria andWithSwitchesIn(List<String> values) {
            addCriterion("with_switches in", values, "withSwitches");
            return (Criteria) this;
        }

        public Criteria andWithSwitchesNotIn(List<String> values) {
            addCriterion("with_switches not in", values, "withSwitches");
            return (Criteria) this;
        }

        public Criteria andWithSwitchesBetween(String value1, String value2) {
            addCriterion("with_switches between", value1, value2, "withSwitches");
            return (Criteria) this;
        }

        public Criteria andWithSwitchesNotBetween(String value1, String value2) {
            addCriterion("with_switches not between", value1, value2, "withSwitches");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNull() {
            addCriterion("operator_name is null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNotNull() {
            addCriterion("operator_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameEqualTo(String value) {
            addCriterion("operator_name =", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotEqualTo(String value) {
            addCriterion("operator_name <>", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThan(String value) {
            addCriterion("operator_name >", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("operator_name >=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThan(String value) {
            addCriterion("operator_name <", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThanOrEqualTo(String value) {
            addCriterion("operator_name <=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLike(String value) {
            addCriterion("operator_name like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotLike(String value) {
            addCriterion("operator_name not like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIn(List<String> values) {
            addCriterion("operator_name in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotIn(List<String> values) {
            addCriterion("operator_name not in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameBetween(String value1, String value2) {
            addCriterion("operator_name between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotBetween(String value1, String value2) {
            addCriterion("operator_name not between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperationDateIsNull() {
            addCriterion("operation_date is null");
            return (Criteria) this;
        }

        public Criteria andOperationDateIsNotNull() {
            addCriterion("operation_date is not null");
            return (Criteria) this;
        }

        public Criteria andOperationDateEqualTo(String value) {
            addCriterion("operation_date =", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateNotEqualTo(String value) {
            addCriterion("operation_date <>", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateGreaterThan(String value) {
            addCriterion("operation_date >", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateGreaterThanOrEqualTo(String value) {
            addCriterion("operation_date >=", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateLessThan(String value) {
            addCriterion("operation_date <", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateLessThanOrEqualTo(String value) {
            addCriterion("operation_date <=", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateLike(String value) {
            addCriterion("operation_date like", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateNotLike(String value) {
            addCriterion("operation_date not like", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateIn(List<String> values) {
            addCriterion("operation_date in", values, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateNotIn(List<String> values) {
            addCriterion("operation_date not in", values, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateBetween(String value1, String value2) {
            addCriterion("operation_date between", value1, value2, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateNotBetween(String value1, String value2) {
            addCriterion("operation_date not between", value1, value2, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIsNull() {
            addCriterion("operation_time is null");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIsNotNull() {
            addCriterion("operation_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperationTimeEqualTo(String value) {
            addCriterion("operation_time =", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotEqualTo(String value) {
            addCriterion("operation_time <>", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeGreaterThan(String value) {
            addCriterion("operation_time >", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeGreaterThanOrEqualTo(String value) {
            addCriterion("operation_time >=", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeLessThan(String value) {
            addCriterion("operation_time <", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeLessThanOrEqualTo(String value) {
            addCriterion("operation_time <=", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeLike(String value) {
            addCriterion("operation_time like", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotLike(String value) {
            addCriterion("operation_time not like", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIn(List<String> values) {
            addCriterion("operation_time in", values, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotIn(List<String> values) {
            addCriterion("operation_time not in", values, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeBetween(String value1, String value2) {
            addCriterion("operation_time between", value1, value2, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotBetween(String value1, String value2) {
            addCriterion("operation_time not between", value1, value2, "operationTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table detail
     *
     * @mbggenerated do_not_delete_during_merge Wed Aug 11 21:50:55 CST 2021
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table detail
     *
     * @mbggenerated Wed Aug 11 21:50:55 CST 2021
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value) {
            super();
            this.condition = condition;
            this.value = value;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.betweenValue = true;
        }
    }
}