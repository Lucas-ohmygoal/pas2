package com.jfl.pas2.domain;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user
     *
     * @mbggenerated Mon Jul 12 08:13:19 CST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user
     *
     * @mbggenerated Mon Jul 12 08:13:19 CST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user
     *
     * @mbggenerated Mon Jul 12 08:13:19 CST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Mon Jul 12 08:13:19 CST 2021
     */
    public UserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Mon Jul 12 08:13:19 CST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Mon Jul 12 08:13:19 CST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Mon Jul 12 08:13:19 CST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Mon Jul 12 08:13:19 CST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Mon Jul 12 08:13:19 CST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Mon Jul 12 08:13:19 CST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Mon Jul 12 08:13:19 CST 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Mon Jul 12 08:13:19 CST 2021
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
     * This method corresponds to the database table user
     *
     * @mbggenerated Mon Jul 12 08:13:19 CST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Mon Jul 12 08:13:19 CST 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user
     *
     * @mbggenerated Mon Jul 12 08:13:19 CST 2021
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPriorityIsNull() {
            addCriterion("user_priority is null");
            return (Criteria) this;
        }

        public Criteria andUserPriorityIsNotNull() {
            addCriterion("user_priority is not null");
            return (Criteria) this;
        }

        public Criteria andUserPriorityEqualTo(Integer value) {
            addCriterion("user_priority =", value, "userPriority");
            return (Criteria) this;
        }

        public Criteria andUserPriorityNotEqualTo(Integer value) {
            addCriterion("user_priority <>", value, "userPriority");
            return (Criteria) this;
        }

        public Criteria andUserPriorityGreaterThan(Integer value) {
            addCriterion("user_priority >", value, "userPriority");
            return (Criteria) this;
        }

        public Criteria andUserPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_priority >=", value, "userPriority");
            return (Criteria) this;
        }

        public Criteria andUserPriorityLessThan(Integer value) {
            addCriterion("user_priority <", value, "userPriority");
            return (Criteria) this;
        }

        public Criteria andUserPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("user_priority <=", value, "userPriority");
            return (Criteria) this;
        }

        public Criteria andUserPriorityIn(List<Integer> values) {
            addCriterion("user_priority in", values, "userPriority");
            return (Criteria) this;
        }

        public Criteria andUserPriorityNotIn(List<Integer> values) {
            addCriterion("user_priority not in", values, "userPriority");
            return (Criteria) this;
        }

        public Criteria andUserPriorityBetween(Integer value1, Integer value2) {
            addCriterion("user_priority between", value1, value2, "userPriority");
            return (Criteria) this;
        }

        public Criteria andUserPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("user_priority not between", value1, value2, "userPriority");
            return (Criteria) this;
        }

        public Criteria andIsMemorizedIsNull() {
            addCriterion("is_memorized is null");
            return (Criteria) this;
        }

        public Criteria andIsMemorizedIsNotNull() {
            addCriterion("is_memorized is not null");
            return (Criteria) this;
        }

        public Criteria andIsMemorizedEqualTo(String value) {
            addCriterion("is_memorized =", value, "isMemorized");
            return (Criteria) this;
        }

        public Criteria andIsMemorizedNotEqualTo(String value) {
            addCriterion("is_memorized <>", value, "isMemorized");
            return (Criteria) this;
        }

        public Criteria andIsMemorizedGreaterThan(String value) {
            addCriterion("is_memorized >", value, "isMemorized");
            return (Criteria) this;
        }

        public Criteria andIsMemorizedGreaterThanOrEqualTo(String value) {
            addCriterion("is_memorized >=", value, "isMemorized");
            return (Criteria) this;
        }

        public Criteria andIsMemorizedLessThan(String value) {
            addCriterion("is_memorized <", value, "isMemorized");
            return (Criteria) this;
        }

        public Criteria andIsMemorizedLessThanOrEqualTo(String value) {
            addCriterion("is_memorized <=", value, "isMemorized");
            return (Criteria) this;
        }

        public Criteria andIsMemorizedLike(String value) {
            addCriterion("is_memorized like", value, "isMemorized");
            return (Criteria) this;
        }

        public Criteria andIsMemorizedNotLike(String value) {
            addCriterion("is_memorized not like", value, "isMemorized");
            return (Criteria) this;
        }

        public Criteria andIsMemorizedIn(List<String> values) {
            addCriterion("is_memorized in", values, "isMemorized");
            return (Criteria) this;
        }

        public Criteria andIsMemorizedNotIn(List<String> values) {
            addCriterion("is_memorized not in", values, "isMemorized");
            return (Criteria) this;
        }

        public Criteria andIsMemorizedBetween(String value1, String value2) {
            addCriterion("is_memorized between", value1, value2, "isMemorized");
            return (Criteria) this;
        }

        public Criteria andIsMemorizedNotBetween(String value1, String value2) {
            addCriterion("is_memorized not between", value1, value2, "isMemorized");
            return (Criteria) this;
        }

        public Criteria andIsAutoLoginIsNull() {
            addCriterion("is_auto_login is null");
            return (Criteria) this;
        }

        public Criteria andIsAutoLoginIsNotNull() {
            addCriterion("is_auto_login is not null");
            return (Criteria) this;
        }

        public Criteria andIsAutoLoginEqualTo(String value) {
            addCriterion("is_auto_login =", value, "isAutoLogin");
            return (Criteria) this;
        }

        public Criteria andIsAutoLoginNotEqualTo(String value) {
            addCriterion("is_auto_login <>", value, "isAutoLogin");
            return (Criteria) this;
        }

        public Criteria andIsAutoLoginGreaterThan(String value) {
            addCriterion("is_auto_login >", value, "isAutoLogin");
            return (Criteria) this;
        }

        public Criteria andIsAutoLoginGreaterThanOrEqualTo(String value) {
            addCriterion("is_auto_login >=", value, "isAutoLogin");
            return (Criteria) this;
        }

        public Criteria andIsAutoLoginLessThan(String value) {
            addCriterion("is_auto_login <", value, "isAutoLogin");
            return (Criteria) this;
        }

        public Criteria andIsAutoLoginLessThanOrEqualTo(String value) {
            addCriterion("is_auto_login <=", value, "isAutoLogin");
            return (Criteria) this;
        }

        public Criteria andIsAutoLoginLike(String value) {
            addCriterion("is_auto_login like", value, "isAutoLogin");
            return (Criteria) this;
        }

        public Criteria andIsAutoLoginNotLike(String value) {
            addCriterion("is_auto_login not like", value, "isAutoLogin");
            return (Criteria) this;
        }

        public Criteria andIsAutoLoginIn(List<String> values) {
            addCriterion("is_auto_login in", values, "isAutoLogin");
            return (Criteria) this;
        }

        public Criteria andIsAutoLoginNotIn(List<String> values) {
            addCriterion("is_auto_login not in", values, "isAutoLogin");
            return (Criteria) this;
        }

        public Criteria andIsAutoLoginBetween(String value1, String value2) {
            addCriterion("is_auto_login between", value1, value2, "isAutoLogin");
            return (Criteria) this;
        }

        public Criteria andIsAutoLoginNotBetween(String value1, String value2) {
            addCriterion("is_auto_login not between", value1, value2, "isAutoLogin");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user
     *
     * @mbggenerated do_not_delete_during_merge Mon Jul 12 08:13:19 CST 2021
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user
     *
     * @mbggenerated Mon Jul 12 08:13:19 CST 2021
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