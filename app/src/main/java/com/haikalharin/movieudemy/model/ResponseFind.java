package com.haikalharin.movieudemy.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseFind{

	@SerializedName("person_results")
	private List<Object> personResults;

	@SerializedName("movie_results")
	private List<Object> movieResults;

	@SerializedName("tv_results")
	private List<Object> tvResults;

	@SerializedName("tv_episode_results")
	private List<Object> tvEpisodeResults;

	@SerializedName("tv_season_results")
	private List<Object> tvSeasonResults;

	public List<Object> getPersonResults(){
		return personResults;
	}

	public List<Object> getMovieResults(){
		return movieResults;
	}

	public List<Object> getTvResults(){
		return tvResults;
	}

	public List<Object> getTvEpisodeResults(){
		return tvEpisodeResults;
	}

	public List<Object> getTvSeasonResults(){
		return tvSeasonResults;
	}
}