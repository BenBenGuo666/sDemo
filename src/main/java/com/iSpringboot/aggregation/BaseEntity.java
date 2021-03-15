package com.iSpringboot.aggregation;

/**
 * @author guoga
 * @version 16:45 2020/6/6
 */
public class BaseEntity
{
    private Integer id;
    private String name;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public BaseEntity add()
    {
        return new BaseEntity();
    }

}
