package com.yuewan.paper.domain;

public class Group {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column group.id
     *
     * @mbg.generated Fri Aug 23 14:22:42 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column group.d_id
     *
     * @mbg.generated Fri Aug 23 14:22:42 CST 2019
     */
    private Integer dId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column group.name
     *
     * @mbg.generated Fri Aug 23 14:22:42 CST 2019
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column group.id
     *
     * @return the value of group.id
     *
     * @mbg.generated Fri Aug 23 14:22:42 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column group.id
     *
     * @param id the value for group.id
     *
     * @mbg.generated Fri Aug 23 14:22:42 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column group.d_id
     *
     * @return the value of group.d_id
     *
     * @mbg.generated Fri Aug 23 14:22:42 CST 2019
     */
    public Integer getdId() {
        return dId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column group.d_id
     *
     * @param dId the value for group.d_id
     *
     * @mbg.generated Fri Aug 23 14:22:42 CST 2019
     */
    public void setdId(Integer dId) {
        this.dId = dId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column group.name
     *
     * @return the value of group.name
     *
     * @mbg.generated Fri Aug 23 14:22:42 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column group.name
     *
     * @param name the value for group.name
     *
     * @mbg.generated Fri Aug 23 14:22:42 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}