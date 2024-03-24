package models;
public class PanierItem {
	private Article article;
    private int quantity;
	public PanierItem() {
	}
	
	public PanierItem(Article article, int quantity) {
		super();
		this.article = article;
		this.quantity = quantity;
	}


	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}


