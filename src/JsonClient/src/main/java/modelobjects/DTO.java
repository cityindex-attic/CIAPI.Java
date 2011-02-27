package modelobjects;

import java.util.Map;


public class DTO {

	private String id;
	private String type;
	private String description;
	private Map<String, Property> properties;
	/*
	"NewsDetailDTO": {
	"id": "NewsDetailDTO",
	"type": "object",
	"description": "Contains details of a specific news story",
	"extends": {
	  "$ref": "#.NewsDTO"
	},
	"properties": {
	  "Story": {
	    "type": "string",
	    "description": "The detail of the story. This can contain HTML characters.",
	    "minLength": 0,
	    "maxLength": 2147483647
	  }
	}
	 */
}
