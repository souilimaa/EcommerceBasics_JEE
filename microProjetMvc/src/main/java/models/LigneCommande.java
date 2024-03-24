package models;

public class LigneCommande {
	 private int numCommande;
	    private int codeArticle;
	    private int qteCde;
		public LigneCommande() {
			
		}
		public LigneCommande(int numCommande, int codeArticle, int qteCde) {
			super();
			this.numCommande = numCommande;
			this.codeArticle = codeArticle;
			this.qteCde = qteCde;
		}
		public int getNumCommande() {
			return numCommande;
		}
		public void setNumCommande(int numCommande) {
			this.numCommande = numCommande;
		}
		public int getCodeArticle() {
			return codeArticle;
		}
		public void setCodeArticle(int codeArticle) {
			this.codeArticle = codeArticle;
		}
		public int getQteCde() {
			return qteCde;
		}
		public void setQteCde(int qteCde) {
			this.qteCde = qteCde;
		}
		
	    
}
