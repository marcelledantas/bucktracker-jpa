package com.keysoft.bucktrackerjpa.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Release
{

	public Release()
	{
	}

	public Release(
		final Integer id,
		final LocalDate releaseDate,
		final String description,
		final ArrayList applications )
	{
		this.id = id;
		this.releaseDate = releaseDate;
		this.description = description;
		this.applications = applications;
	}

	public void addApplication( final Application application )
	{
		this.applications.add( application );
	}

	public List<Application> getApplications()
	{
		return this.applications;
	}

	public String getDescription()
	{
		return this.description;
	}

	public Integer getId()
	{
		return this.id;
	}

	public LocalDate getReleaseDate()
	{
		return this.releaseDate;
	}

	public void setApplications( final List<Application> applications )
	{
		this.applications = applications;
	}

	public void setDescription( final String description )
	{
		this.description = description;
	}

	public void setId( final Integer id )
	{
		this.id = id;
	}

	public void setReleaseDate( final LocalDate releaseDate )
	{
		this.releaseDate = releaseDate;
	}

	@OneToMany
	private List<Application> applications = new ArrayList<>();

	private String description;

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Integer id;

	@JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" )
	private LocalDate releaseDate;
}
