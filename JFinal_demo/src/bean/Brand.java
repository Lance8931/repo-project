package bean;

import java.util.Date;

import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("rawtypes")
public class Brand extends Model<Model> {
	private static final long serialVersionUID = -7553544535597532683L;

	private Integer id;

	private String brandName;

	private Boolean status;

	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName == null ? null : brandName.trim();
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}