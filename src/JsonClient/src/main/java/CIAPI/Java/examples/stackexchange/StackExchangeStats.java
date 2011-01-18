package CIAPI.Java.examples.stackexchange;

public class StackExchangeStats {
	private int total_questions;
	private int total_unanswered;
	private int total_accepted;
	private int total_answers;
	private int total_comments;
	private int total_votes;
	private int total_badges;
	private int total_users;
	private double questions_per_minute;
	private double answers_per_minute;
	private double badges_per_minute;
	private double views_per_day;
	private Version api_version;
	private Site site;

	public int getTotal_questions() {
		return total_questions;
	}

	public int getTotal_unanswered() {
		return total_unanswered;
	}

	public int getTotal_accepted() {
		return total_accepted;
	}

	public int getTotal_answers() {
		return total_answers;
	}

	public int getTotal_comments() {
		return total_comments;
	}

	public int getTotal_votes() {
		return total_votes;
	}

	public int getTotal_badges() {
		return total_badges;
	}

	public int getTotal_users() {
		return total_users;
	}

	public double getQuestions_per_minute() {
		return questions_per_minute;
	}

	public double getAnswers_per_minute() {
		return answers_per_minute;
	}

	public double getBadges_per_minute() {
		return badges_per_minute;
	}

	public double getViews_per_day() {
		return views_per_day;
	}

	public Version getApi_version() {
		return api_version;
	}

	public Site getSite() {
		return site;
	}
}
