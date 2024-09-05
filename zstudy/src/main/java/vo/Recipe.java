package vo;

public class Recipe {

    private String title;
    private String userId;
    private String category;
    private String img;
    private String recipeDescription ;
    
    public Recipe() {
		
	}
	public Recipe(String title, String userId, String category, String img, String recipeDescription) {
		super();
		this.title = title;
		this.userId = userId;
		this.category = category;
		this.img = img;
		this.recipeDescription = recipeDescription;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getRecipeDescription() {
		return recipeDescription;
	}
	public void setRecipeDescription(String recipeDescription) {
		this.recipeDescription = recipeDescription;
	}
	@Override
	public String toString() {
		return "Recipe [title=" + title + ", userId=" + userId + ", category=" + category + ", img=" + img
				+ ", recipeDescription=" + recipeDescription + "]";
	}


}
