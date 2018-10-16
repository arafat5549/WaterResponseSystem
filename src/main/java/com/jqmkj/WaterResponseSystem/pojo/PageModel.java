package com.jqmkj.WaterResponseSystem.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jqmkj.WaterResponseSystem.util.EncodeUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@JSONType(ignores = {"data"})
public class PageModel<T> implements  Serializable {

    public static final String F_DATA = "data";
    //private static final long serialVersionUID = 1L;
    private int page = 1;
    private int size = 10;

    /**
     * 查询条件json
     */
    @JsonIgnore
    private String queryConditionJson;
    private long recordsTotal;
    private long recordsFiltered;
    private int draw;

    //@JSONField(name = "data", serialzeFeatures = {SerializerFeature.WriteNullListAsEmpty})
    private List<T> data;

    public PageModel() {
    }

    /**
     * Creates a new {@link PageRequest}. Pages are zero indexed, thus providing 0 for {@code page} will return the first
     * page.
     *
     * @param page zero-based page index.
     * @param size the size of the page to be returned.
     */
    public PageModel(int page, int size) {
        this(page, size, null);
    }

    public PageModel(int page, int size, List<T> dataList, long recordsTotal) {
        this(page, size, null);
        setData(dataList);
        setRecordsTotal(recordsTotal);
    }

    /**
     * Creates a new {@link PageRequest} with sort parameters applied.
     *
     * @param page       zero-based page index.
     * @param size       the size of the page to be returned.
     * @param direction  the direction of the {@link Sort} to be specified, can be {@literal null}.
     * @param properties the properties to sort by, must not be {@literal null} or empty.
     */
    public PageModel(int page, int size, Sort.Direction direction, String... properties) {
        this(page, size, new Sort(direction, properties));
    }

    /**
     * Creates a new {@link PageRequest} with sort parameters applied.
     *
     * @param page zero-based page index.
     * @param size the size of the page to be returned.
     * @param sort can be {@literal null}.
     */
    public PageModel(int page, int size, Sort sort) {
        if (page < 0) {
            throw new IllegalArgumentException("Page index must not be less than zero!");
        }

        if (size < 1) {
            throw new IllegalArgumentException("Page size must not be less than one!");
        }

        this.page = page;
        this.size = size;
        //this.setSort(sort);
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setPageInstance(Page<T> page) {
        setData(page.getContent());
        setRecordsTotal(page.getTotalElements());
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
    public void setPage(Integer page) {
        if(page!=null)
            this.page = page;
    }
    public int getSize() {
        return size;
    }
    public void setSize(Integer size) {
        if(size!=null)
            this.size = size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public String getQueryConditionJson() {
        return queryConditionJson;
    }

    public void setQueryConditionJson(String queryConditionJson) {
        this.queryConditionJson = EncodeUtils.unescapeHtml(queryConditionJson);
    }

//    public void setSortName(String sort) {
//        if (sort.contains(" ")) {
//            String[] sts = sort.split(" ");
//            this.sort = new Sort(Sort.Direction.fromString(sts[1]), sts[0]);
//        } else {
//            this.sort = new Sort(Sort.Direction.ASC, sort);
//        }
//    }
//
//    public void setSortDefaultName(Sort.Direction direction, String... sorts) {
//        if (sort == null) {
//            this.sort = new Sort(direction, sorts);
//        }
//    }
//    @JsonIgnore
//    public int getPageSize() {
//        return size;
//    }
//
//    @JsonIgnore
//    public int getPageNumber() {
//        return page;
//    }
//
//    @JsonIgnore
//    public long getOffset() {
//        return (page - 1) * size;
//    }
//
//
//    public boolean hasPrevious() {
//        return page > 0;
//    }


//    public Pageable previousOrFirst() {
//        return hasPrevious() ? previous() : first();
//    }


    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;

        result = prime * result + page;
        result = prime * result + size;

        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        PageModel other = (PageModel) obj;
        return this.page == other.page && this.size == other.size;
    }

//    @Override
//    public Sort getSort() {
//        return sort;
//    }
//
//    public void setSort(Sort sort) {
//        this.sort = sort;
//    }
//    public Pageable next() {
//        return new PageRequest(getPageNumber() + 1, getPageSize(), getSort());
//    }
//
//
//    public PageModel previous() {
//        return getPageNumber() == 0 ? this : new PageModel(getPageNumber() - 1, getPageSize(), getSort());
//    }
//    public Pageable first() {
//        return new PageRequest(0, getPageSize(), getSort());
//    }

//    public <S> PageModel<S> map(Converter<? super T, ? extends S> converter) {
//        return new PageModel(this.getPage(), this.getSize(),
//                this.getConvertedContent(converter), this.getRecordsTotal());
//    }

//    protected <S> List<S> getConvertedContent(Converter<? super T, ? extends S> converter) {
//        Assert.notNull(converter, "Converter must not be null!");
//        List<S> result = new ArrayList(this.data.size());
//        Iterator var3 = this.data.iterator();
//
//        while (var3.hasNext()) {
//            T element = (T) var3.next();
//            result.add(converter.convert(element));
//        }
//
//        return result;
//    }

    public long getRecordsFiltered() {
        if (recordsFiltered == 0) recordsFiltered = getRecordsTotal();
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }


    @Override
    public String toString() {
        return "PageModel{" +
                "page=" + page +
                ", size=" + size +
                ", queryConditionJson='" + queryConditionJson + '\'' +
                ", recordsTotal=" + recordsTotal +
                ", recordsFiltered=" + recordsFiltered +
                ", draw=" + draw +
                ", data=" + data +
                '}';
    }
}
