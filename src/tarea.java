import java.util.Scanner;
public class tarea{
	
	public static Scanner lector = new Scanner (System.in);
	
	/**
	*createMaterial This method is used for the user to enter the name of each material, quantity and type of use.
	*<b> pos: </b>: I am giving values to the array work
	*@param material Name of de materials
	*@param	amountProduct Amount of each material
	*@param work Type of use
	*@return output, is a array.
	*/
	
	public static int [] createMaterials(String[] material, 
	double[] amountProduct,Utility[] work){
			
			int [] output = new int[3]; //This array have the role to save the information in blackW, whiteW and paintW.
			
		 int blackW, whiteW, paintW; //These variables have the role of storing the sum of the enum Utility.

		 
		 blackW=0;
		 whiteW=0;
		 paintW=0;
		
		for (int i=0;i<material.length;i++){      
					
					lector.nextLine();
					
					System.out.println("Material #"+(i+1));
					
					material[i]=lector.nextLine();
					
					System.out.println("Ingrese cantidad a llevar de este material: ");
					
					amountProduct[i]=lector.nextInt();
					
					System.out.println("Tipo de utilizacion (1.Obra negra /2. Obra blanca /3. Pintura)");
					
					int joinUtility=lector.nextInt();
					work[i]=null;
					
					switch (joinUtility){
						case 1:
							work[i]=Utility.OBRANEGRA;
							blackW++;
							break;
						case 2:
							work[i]=Utility.OBRABLANCA;
							whiteW++;
							break;
						case 3:
							work[i]=Utility.PINTURA;
							paintW++;
							break;
					}
				}
			output[0]=blackW;
			output[1]=whiteW;
			output[2]=paintW;
			return output;
	}
	
	
		public static void main (String[] args){                                 // MAIN METHOD 
			
			int blackW,whiteW,paintW;
			
			double totalWork; // This variable works based on the enum Utility, and would refer to the truth table.
			
			System.out.println("Ingrese la cantidad de materiales asignados (cantidad por tipo): ");
		
			int totalMaterial = lector.nextInt(); // This lector is to receive the total of materials.
			
			String [] material = new String[totalMaterial];  // Array to save the names of materials.
			
			double [] priceHomecenter = new double[totalMaterial]; //Array to save the price of the materials in Homecenter.
			
			double [] priceFcentro = new double[totalMaterial]; //Array to save the price of the materials in Ferretería del Centro.
			
			double [] priceFbarrio = new double[totalMaterial]; //Array to save the price of the materials in Ferreteria del Barrio.
			
			double [] amountProduct = new double[totalMaterial]; // The quantity of each product (example: 10 bricks).
			 
			Utility [] work = new Utility[totalMaterial]; // Declare the work variable as an array with the enum Utility.
			
			Ubication placeUbi; // Declare the variable placeUbi (place of location for the address) with enum Ubication.
			
			System.out.println("Ingrese el nombre de cada material (por tipo): ");
			
			int [] workHand = createMaterials(material, amountProduct, work);               // CALL TO METHOD.
			
			blackW=workHand[0];
			whiteW=workHand[1];
			paintW=workHand[2];
				
					totalWork=0;														 //Truth table analogy
																										
				if (blackW>0 && whiteW>0 && paintW>0){     // V - V - V 
					totalWork=4880000;  
				}if (blackW>0 && whiteW>0 && paintW==0){   // V - V - F
					totalWork=3900000;
				}if (blackW>0 && whiteW==0 && paintW==0){   // V - F - F
					totalWork=1300000;
				}if (blackW==0 && whiteW==0 && paintW>0){   // F - F - V
					totalWork=980000;
				}if (blackW==0 && whiteW>0 && paintW>0){   // F - V - V
					totalWork=3580000;
				}if (blackW>0 && whiteW==0 && paintW>0){   // V - F - V
					totalWork=2280000;
				}if (blackW==0 && whiteW>0 && paintW==0){   // F - V - F
					totalWork=2600000;
				}
				
			System.out.println("Ahora bien, hay 3 lugares donde se pueden conseguir dichos materiales. Dichos lugares son: Homecenter, Ferreteria del Centro y Ferreteria del Barrio. ");
				
			System.out.println("Primero, digite los valores de compra por unidad de los materiales en HOMECENTER: ");
				
				double hcPayment=0;  // This variable have the role of save the total to pay at Homecenter.
				double multiHC=0; //This variable is only to save a multiplication between the arrays of prices and amount of each material.
				
				for (int i=0;i<totalMaterial;i++){                                          //PRICE OF MATERIALS IN HOMECENTER
					
					System.out.println("Precio del material ("+material[i]+"):");
					
					priceHomecenter[i]=lector.nextDouble();
					
					multiHC = priceHomecenter[i]*amountProduct[i];
					
					hcPayment=hcPayment+multiHC;
					
				}
			
			System.out.println("Segundo, digite los valores de compra por unidad de los materiales en FERRETERIA DEL CENTRO");
			
				double fcPayment=0; // This variable have the role of save the total to pay at Ferreteria del centro.
				double multiFC=0;  //This variable is only to save a multiplication between the arrays of prices and amount of each material.
			
				for (int i=0;i<totalMaterial;i++){                                          //PRICE OF MATERIALS IN FERRETERIA DEL CENTRO
					
					System.out.println("Precio del material ("+material[i]+"):");
					
					priceFcentro[i]=lector.nextDouble();
					
					multiFC=priceFcentro[i]*amountProduct[i];
					
					fcPayment=fcPayment+multiFC;
					
				}
				
			System.out.println("Tercero, digite los valores de compra por unidad de los materiales en FERRETERIA DEL BARRIO");
			
				double fbPayment=0; // This variable have the role of save the total to pay at Ferreteria del barrio.
				double multiFB=0;  //This variable is only to save a multiplication between the arrays of prices and amount of each material.
				
				for (int i=0;i<totalMaterial;i++){                                         //PRICE OF MATERIALS IN FERRETERIA DEL BARRIO
					
					System.out.println("Precio del material ("+material[i]+"):");
					
					priceFbarrio[i]=lector.nextDouble();
					
					multiFB=priceFbarrio[i]*amountProduct[i];
					
					fbPayment=fbPayment+(priceFbarrio[i]*amountProduct[i]);
					
				}
				
			System.out.println("Desea solicitar domicilio: Si (1) / No(0)");
			
				int option = lector.nextInt();
			
				if (option==1){
					
					System.out.println("Defina la ubicacion de entrega (1. Norte /2. Centro /3. Sur): ");
					
					int joinUbication=lector.nextInt();  // 
					
					placeUbi=null;
					
					switch (joinUbication){
						case 1:
							placeUbi=Ubication.NORTE;
								break;
						case 2:
							placeUbi=Ubication.CENTRO;
								break;
						case 3:
							placeUbi=Ubication.SUR;
								break;
					}
					
					if (placeUbi==Ubication.NORTE){              // DELIVERY AT NORTH     <--------------------------------NORTH
						
						if(hcPayment>300000){                                                  // TOTAL PURCHASE HOMECENTER
				
								System.out.println("El total a pagar en Homecenter es: "+(hcPayment+totalWork));
						
						}if(hcPayment<=80000){
							
							System.out.println("El total a pagar en Homecenter es: "+(hcPayment+totalWork+120000));
							
							}else{
									
									System.out.println("El total a pagar en Homecenter es: "+(hcPayment+totalWork+28000));
									
								}
								
							if(fcPayment>300000){                                                  //TOTAL PURCHASE FERRETERIA DEL CENTRO
				
								System.out.println("El total a pagar en ferreteria del centro es: "+(fcPayment+totalWork));
						
						}if(fcPayment<=80000){
							
							System.out.println("El total a pagar en ferreteria del centro es: "+(fcPayment+totalWork+120000));
							
							}else{
									
									System.out.println("El total a pagar en ferreteria del centro es: "+(fcPayment+totalWork+28000));
									
								}
								
							if(fbPayment>300000){                                                 //TOTAL PURCHASE FERRETERIA DEL BARRIO
				
								System.out.println("El total a pagar en ferreteria del barrio es: "+(fbPayment+totalWork));
						
						}if(fbPayment<=80000){
							
							System.out.println("El total a pagar en ferreteria del barrio es: "+(fbPayment+totalWork+120000));
							
							}else{
									
									System.out.println("El total a pagar en ferreteria del barrio es: "+(fbPayment+totalWork+28000));
									
								}
					
						}
						if(placeUbi==Ubication.CENTRO){                     // DELIVERY AT CENTER     <------------------------CENTER
							
							if(hcPayment>300000){                                               // TOTAL PURCHASE HOMECENTER
				
								System.out.println("El total a pagar en Homecenter es: "+(hcPayment+totalWork));
						
							}if(hcPayment<=80000){
							
								System.out.println("El total a pagar en Homecenter es: "+(hcPayment+totalWork+50000));
							
								}else{
									
									System.out.println("El total a pagar en Homecenter es: "+(hcPayment+totalWork));
									
								}
								
							if(fcPayment>300000){                                              //TOTAL PURCHASE FERRETERIA DEL CENTRO
				
								System.out.println("El total a pagar en ferreteria del centro es: "+(fcPayment+totalWork));
						
						}if(fcPayment<=80000){
							
							System.out.println("El total a pagar en ferreteria del centro es: "+(fcPayment+totalWork+50000));
							
							}else{
									
									System.out.println("El total a pagar en ferreteria del centro es: "+(fcPayment+totalWork));
									
								}
								
							if(fbPayment>300000){                                             //TOTAL PURCHASE FERRETERIA DEL BARRIO
				
								System.out.println("El total a pagar en ferreteria del barrio es: "+(fbPayment+totalWork));
						
						}if(fbPayment<=80000){
							
							System.out.println("El total a pagar en ferreteria del barrio es: "+(fbPayment+totalWork+50000));
							
							}else{
									
									System.out.println("El total a pagar en ferreteria del barrio es: "+(fbPayment+totalWork));
									
								}
							
						}
						if(placeUbi==Ubication.SUR){                        // DELIVERY AT SOUTH   <---------------------------------SOUTH
							
							if(hcPayment>300000){    // TOTAL PURCHASE HOMECENTER
				
								System.out.println("El total a pagar en Homecenter es: "+(hcPayment+totalWork));
						
						}if(hcPayment<=80000){
							
							System.out.println("El total a pagar en Homecenter es: "+(hcPayment+totalWork+120000));
							
							}else{
									
									System.out.println("El total a pagar en Homecenter es: "+(hcPayment+totalWork+55000));
									
								}
								
							if(fcPayment>300000){     //TOTAL PURCHASE FERRETERIA DEL CENTRO
				
								System.out.println("El total a pagar en ferreteria del centro es: "+(fcPayment+totalWork));
						
						}if(fcPayment<=80000){
							
							System.out.println("El total a pagar en ferreteria del centro es: "+(fcPayment+totalWork+120000));
							
							}else{
									
									System.out.println("El total a pagar en ferreteria del centro es: "+(fcPayment+totalWork+55000));
									
								}
								
							if(fbPayment>300000){    //TOTAL PURCHASE FERRETERIA DEL BARRIO
				
								System.out.println("El total a pagar en ferreteria del barrio es: "+(fbPayment+totalWork));
						
						}if(fbPayment<=80000){
							
							System.out.println("El total a pagar en ferreteria del barrio es: "+(fbPayment+totalWork+120000));
							
							}else{
									
									System.out.println("El total a pagar en ferreteria del barrio es: "+(fbPayment+totalWork+55000));
									
								}
							
						}
						
				}else{                                                                              // NOT DELIVERY
					System.out.println("El total a pagar en Homecenter es: "+(hcPayment+totalWork));
					System.out.println("El total a pagar en ferreteria del barrio es: "+(fcPayment+totalWork));
					System.out.println("El total a pagar en ferreteria del barrio es: "+(fbPayment+totalWork));
				}
				
				double [] bestPrice= new double[totalMaterial]; // Array to save cheap prices between Homecenter, ferreteria del centro y ferreteria del barrio
				
				String [] bestStore=new String[totalMaterial]; //Array to save the store with the best price.
				
				for (int i=0;i<totalMaterial;i++){
					
					if(priceHomecenter[i]<priceFcentro[i] && priceHomecenter[i]<priceFbarrio[i]){
						
						bestPrice[i]=priceHomecenter[i];
						bestStore[i]="Homecenter";
						
				}if(priceFcentro[i]<priceHomecenter[i] && priceFcentro[i]<priceFbarrio[i]){
						bestPrice[i]=priceFcentro[i];
						bestStore[i]="Ferreteria del centro";
					}if(priceFbarrio[i]<priceHomecenter[i] && priceFbarrio[i]<priceFcentro[i]){
						bestPrice[i]=priceFbarrio[i];
						bestStore[i]="Ferreteria del barrio";
					}
				}
				System.out.println("Ahora, se clasificaron los precios según el mas economico: ");
				
				double multiFinal=0;
				double finalPayment=0;
				
				for(int i=0;i<totalMaterial;i++){
					System.out.println("El material "+material[i]+" es mas economico en: ");
					System.out.println(bestStore[i]+": "+bestPrice[i]);
					
					multiFinal=bestPrice[i]*amountProduct[i];
					finalPayment=finalPayment+multiFinal;
				}
				
				System.out.println("De la forma mas economica, el total a pagar sería (sin domicilio): "+finalPayment+totalWork);
				
		}
}