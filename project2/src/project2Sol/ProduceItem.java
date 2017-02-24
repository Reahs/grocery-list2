package project2Sol;
public abstract class ProduceItem {
	   private String type;
       private String code;
       private String name;
       private float price;
       
       public ProduceItem()
       {
    	   
       }
       // four arguments constructor
       public ProduceItem (String type, String code, String name, float price) {
    	   this.type = type;
    	   this.setCode(code);
    	   this.setName(name);
    	   this.setPrice(price);	   
       }
       //get method for type
       public String getType(){
    	   return type;
       }
       public String getCode() {
   		return code;
   		}
       public String getName() {
		return name;
		}
       public float getPrice() {
   		return price;
   		}
       // set method for type
    public void setType(String type){
    	this.type = type;
    }
	
	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
}      
       
       
       
       
       
       
    			   
    	   
