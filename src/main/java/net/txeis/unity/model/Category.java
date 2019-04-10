package net.txeis.unity.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RSCCC.OneRoster_Categories")
@Access(AccessType.FIELD)
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private UUID sourcedId;

	private String status;

	private Timestamp dateLastModified;

	private String title;

	private String href;

	public UUID getSourcedId() {
		return sourcedId;
	}

	public void setSourcedId(UUID sourcedid) {
		this.sourcedId = sourcedid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDateLastModified() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'", Locale.US);
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		return dateFormat.format(dateLastModified);
	}

	public void setDateLastModified(Timestamp dateLastModified) {
		this.dateLastModified = dateLastModified;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	private Metadt metadata;

	public Metadt getmetadata() {
		return metadata;
	}

	public void setmetadata(Metadt metadata) {
		this.metadata = metadata;
	}

	@Embeddable
	public static class Metadt implements Serializable {
		private static final long serialVersionUID = 1L;

		@Column(name="ClassGuid")
		private UUID classId;

		public Metadt() {
		}

		public Metadt(UUID classId) {
			this.classId = classId;

		}

		public UUID getClassId() {
			return classId;
		}

		public void setClassId(UUID classId) {
			this.classId = classId;
		}

	}

}
