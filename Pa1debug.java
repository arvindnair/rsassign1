//package matcsr1;
import java.io.*;
import java.util.*;
class row_ptrT{
	int notimes=0;
	int value=0;
}
class cosine{
	int item1val=0;
	int item2val=0;
	double cosineval=0.000;
}
class candidate{
	int item1val=0;
	double cosineval=0.000;
}
public class Pa1debug {

	public static void main(String[] args)throws Exception {
        //File fl=new File("11.txt");	
		long startTime=System.currentTimeMillis();
		Scanner sc=new Scanner(new File("train1.txt"));
		int c=0,iconst=0,row=1;
		
		String countn=sc.nextLine();
		String cntemp[]=countn.split(" ");
		int[] cntemp1=new int[cntemp.length];
       for(int i=0;i<cntemp.length;i++){
       	  cntemp1[i]=Integer.parseInt(cntemp[i]);
        }
        int[] val=new int[cntemp1[2]];
		int[] row_ptr=new int[cntemp1[0]+1];
		int[] col_ind=new int[cntemp1[2]];
	//	for(int i=0;i<cntemp1.length;i++){
	 //   System.out.println("cntemp1: "+cntemp1[i]);
	//	}
		
		row_ptr[0]=0;
	while(sc.hasNextLine()){
		String currentline=sc.nextLine();
		String sttemp[]=currentline.split(" ");
		int[] inttemp=new int[sttemp.length];
        for(int i=0;i<sttemp.length;i++){
        	inttemp[i]=Integer.parseInt(sttemp[i]);
        }
        int[] a=new int[inttemp.length];
        a=inttemp.clone();
        for(int i=0;i<a.length;i++){
        	
        	if((i%2)==0){
        	     col_ind[iconst]=a[i];
        	     }
        	else{
        		val[iconst]=a[i];
        		iconst++;
        	}
        
        }
        
        row_ptr[row]=iconst;
        row++;
        
	}
	int max=0;
/*	System.out.println("val: ");
	for(int i=0;i<val.length;i++){
	System.out.print(val[i]+" ");
	}System.out.println();
	System.out.println("colind: ");
	for(int i=0;i<col_ind.length;i++){
		System.out.print(col_ind[i]+" ");
		}System.out.println();
		System.out.println("rowptr: ");
	for(int i=0;i<row_ptr.length;i++){
		System.out.print(row_ptr[i]+" ");
		}*/
	//max=col_ind[0];
	//for(int i=1;i<col_ind.length;i++){
	  //  if(col_ind[i]>max){
	    //	max=col_ind[i];
	    //}
	//}
	//System.out.println("MAx is"+max);
	int col=0;
	int[] valT=new int[val.length];
	int[] col_indT=new int[col_ind.length];
	//int[] row_ptrT=new int[max];
	int row1=0;
	boolean check=false;
	//row_ptrT[0]=0;
	row_ptrT[] rowptr=new row_ptrT[cntemp1[1]+1];
	for(int i=0;i<rowptr.length;i++){
		rowptr[i]=new row_ptrT();
	}
	rowptr[0].notimes=0;
	int c1=0;
	int ce=0;
	for(int k=0;k<col_ind.length;k++){
		for(int y=0;y<rowptr.length;y++){
			if(rowptr[y].value==col_ind[k]){
				check=true;
				break;
		    }
		}
		if(check!=true){
			for(int i=0;i<col_ind.length;i++){
				
				if(col_ind[k]==col_ind[i]){
					valT[ce]=val[i];
					int j=0;
					while(j<row_ptr.length-1){
				     for(int r1=row_ptr[j];r1<row_ptr[j+1];r1++)
						{
				    	 if(i==r1){
				    		 col_indT[ce]=j;
				    		 ce++;
				    	  }
						}j++;
				    }
				}
				}
				rowptr[c1].value=col_ind[k];
				rowptr[c1+1].notimes=ce;//as per assumption rowptr[0].notimes=0
			    c1++;
			}check=false;
		}
	//	else{
			
	//}
/*	System.out.println();
	for(int i=0;i<rowptr.length;i++)
	{
	System.out.print("Row_PtrTV:"+rowptr[i].value+" ");
	System.out.print("Row_PtrTN:"+rowptr[i].notimes+" ");
	}

	System.out.println();
	for(int i=0;i<valT.length;i++)
	{
		System.out.print("ValT:"+valT[i]+" ");
	}
	System.out.println();
	for(int i=0;i<col_indT.length;i++)
	{
		System.out.print("Col_IndT:"+col_indT[i]+" ");
	}*/
	//sc.close();

	//}//end of main method
//}//end of class
	int[] a=new int[cntemp1[1]];
	int[] b=new int[cntemp1[1]];
	double counter=0;
	double counter1=0;
	double counter2=0;
	int[] temp1=new int[cntemp1[1]];
	for(int i=0;i<temp1.length;i++){
		temp1[i]=0;
	}
	cosine[] cosinestr=new cosine[cntemp1[1]];
	for(int i=0;i<cosinestr.length;i++){
		cosinestr[i]=new cosine();
	}
	cosine[][] cosinetable=new cosine[cntemp1[1]][cntemp1[1]];
	for(int i=0;i<cosinetable.length;i++){
		for(int c3=0;c3<cosinetable.length;c3++){
		cosinetable[i][c3]=new cosine();
	    }
	}
	int c3=0;
	for(int k=0;k<rowptr.length-1;k++){
		//cosinestr[k].item1val=rowptr[k].value;
		 for(int i=0;i<a.length;i++){
			    a[i]=0;	
			    }
		 
		 for(int i=rowptr[k].notimes;i<rowptr[k+1].notimes;i++){
			int e=col_indT[i];
			 a[e]=1;
			 
		 }
		 /*for(int i=0;i<4;i++){
			   System.out.println("a="+a[i]);	
			    }*/
		for(int j=0;j<cntemp1[1];j++){
			
			if(rowptr[k].value!=rowptr[j].value&&rowptr[j].value!=0){
				cosinestr[j].item1val=rowptr[k].value;
			cosinestr[j].item2val=rowptr[j].value;
		    for(int i=0;i<b.length;i++){
			    b[i]=0;	
			    }
		 
		 for(int i=rowptr[j].notimes;i<rowptr[j+1].notimes;i++){
			int e=col_indT[i];
			 b[e]=1;
		 }
		/* for(int i=0;i<4;i++){
			   System.out.println("b="+b[i]);	
			    }*/
			for(int i=0;i<a.length;i++){
				if((a[i]!=0)&&(b[i]!=0)){
					counter++;
					//System.out.println("Counter is:"+counter);
				}
			}
			for(int i=0;i<a.length;i++){
				if(a[i]!=0){
					counter1++;
				}
			}
			for(int i=0;i<a.length;i++){
				if(b[i]!=0){
					counter2++;
				}
			}
			double s = counter1*counter2;
			//System.out.println(s);
			cosinestr[j].cosineval=counter/s;
			}
		}
	/*	System.out.println();
		for(int i=0;i<cosinestr.length;i++){
			System.out.println("Cosine for "+cosinestr[i].item1val+" and "+cosinestr[i].item2val+" is "+cosinestr[i].cosineval);
		    }
		sort1(cosinestr);
		for(int i=0;i<cosinestr.length;i++){
			System.out.println("Sorted Cosine for "+cosinestr[i].item1val+" and "+cosinestr[i].item2val+" is "+cosinestr[i].cosineval);
		}*/
		//System.out.println("c3: "+c3);
        for(int i=0;i<cosinestr.length;i++){
        	int x=cosinestr[i].item1val;
        	cosinetable[c3][i].item1val=x;
        	//System.out.println("item1val: "+cosinetable[c3][i].item1val);
        	int y=cosinestr[i].item2val;
        	cosinetable[c3][i].item2val=y;
        	double z=cosinestr[i].cosineval;
        	cosinetable[c3][i].cosineval=z;
        }c3++;
        for(int i=0;i<cosinestr.length;i++){
			cosinestr[i].cosineval=0.0;
			cosinestr[i].item1val=0;
			cosinestr[i].item2val=0;
		}
		}
       /*  for(int i=0;i<cosinetable.length;i++){
        	 System.out.println();
        	 for(int j=0;j<cosinetable.length;j++){
        		 System.out.print("itemval1 is: "+cosinetable[i][j].item1val+"itemval2 is: "+cosinetable[i][j].item2val+"cosineval: "+cosinetable[i][j].cosineval);
        	 }
         }*/
         System.out.println();
     	long endTime=System.currentTimeMillis();
    	float sec=0;
    	sec=(endTime-startTime)/1.0f;
    	System.out.print("The Item Item Similarity Execution took ");
    	System.out.format("%.2f",sec);
    	System.out.println("ms");
    	
    	long startTime1=System.currentTimeMillis();
    	 cosine[] cosinestr1=new cosine[cosinestr.length];
    	 
    	 Scanner sd=new Scanner(new File("test1.txt")); 
    	 String e1=sd.nextLine();
 		String e2[]=e1.split(" ");
 		int[] e3=new int[e2.length];
         for(int i=0;i<e2.length;i++){
         	e3[i]=Integer.parseInt(e2[i]);
         }
         int users=e3[0];
  	     int hits=0;
  	     double rank=0.0;
  	     int kinput=0;
  	     int counterkinput=0;
  	     int ninput=0;
  	     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  	     System.out.println("Enter the K value for K most unpurchased similar items: ");
  	     kinput=Integer.parseInt(br.readLine());
  	     System.out.println("Enter the value of N for Top ranked items: ");
  	     ninput=Integer.parseInt(br.readLine());
  	     BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
  	     System.out.println("Enter the filename: ");
		 String filename=br.readLine();
		 File outFile = new File (filename);
		    FileWriter fWriter = new FileWriter (outFile);
		    PrintWriter pWriter = new PrintWriter (fWriter);
  	     for(int i=0;i<cntemp1[0];i++){//users loop
        	 int c4=0;
        	 
        	 for(int k=0;k<temp1.length;k++){//making temp1 to zero
            	 temp1[k]=0;
                 }//making temp1 to zero
        	 
        	 for(int j=row_ptr[i];j<row_ptr[i+1];j++){//pickout rated items to store in temp1
        		 temp1[c4]=col_ind[j];
        		 c4++;
        	 }//pickout rated items to store in temp1
        	 
        	/* for(int k=0;k<temp1.length;k++){//output temp1
        	 System.out.println("Temp is: "+temp1[k]);
             }*///output temp1
        	 
       // 	 System.out.println();
        	// Arrays.sort(temp1);
        	 
        		for(int r=0;r<cosinestr1.length;r++){//create temporary storing location for objects
        			cosinestr1[r]=new cosine();
        		}//create temporary storing location for objects
        		 
        		cosine[][] cosinetable1=new cosine[cosinetable.length][cosinetable.length];	
      		   for(int k=0;k<cosinetable.length;k++){//create cosinetable1 matrix to store similar unpurchased items
      				for(int c8=0;c8<cosinetable.length;c8++){
      				cosinetable1[k][c8]=new cosine();
      			    }
      			}//create cosinetable1 matrix to store similar unpurchased items
        	   for(int l=0;l<temp1.length;l++){//searching through users purchased items
        			
        		   for(int r=0;r<cosinestr1.length;r++){//create temporary storing location for objects
            			cosinestr1[r]=new cosine();
            		}//create temporary storing location for objects
        		   
        		   if(temp1[l]!=0){//check for zero in array to skip
        		   int c5=temp1[l];
        		   
        		   for(int m=0;m<cosinetable.length;m++){//search row by row of cosine table matrix
        			  
        			   if(cosinetable[m][0].item1val==c5){//check for item equality wrt temp1
        				   int c8=0;
        				counterkinput=0;
        				   for(int n=0;n<cosinetable.length && counterkinput<kinput;n++){//check for column of item selected
        					   
        					   int c6=cosinetable[m][n].item2val;
        					   int c7=0;
        					
        					   for(int p=0;p<temp1.length;p++){//check if item1 & item2 are present in temp1
        						   if(c6==temp1[p]){
        							   c7=1;
        							   break;
        						   }
        					   }
        					   
        					   if(c7!=1){//if not present in temp1 both items copy into cosinestr1
        						   cosinestr1[c8].item1val=cosinetable[m][0].item1val;
        						   cosinestr1[c8].item2val=cosinetable[m][n].item2val;
        						   cosinestr1[c8].cosineval=cosinetable[m][n].cosineval;
        						   c8++;counterkinput++;
        					   }
        					   
        					   
        					 }//check for column of item selected
        					   
        				  
        				   
        					/*for(int k=0;k<cosinestr1.length;k++){//print the cosinestr1 array 
        					   System.out.println("cosinestr1 i1v: "+cosinestr1[k].item1val+"i2v: "+cosinestr1[k].item2val+"cval: "+cosinestr1[k].cosineval);
        					   }  */
        			         int e=0;
        					for(int k=0;k<kinput;k++){
        						
        							
        								cosinetable1[l][e].item1val=cosinestr1[k].item1val;
        								cosinetable1[l][e].item2val=cosinestr1[k].item2val;
        								cosinetable1[l][e].cosineval=cosinestr1[k].cosineval;
        							    e++;
        						}
        			   }//check for item equality wrt temp1
        			   
        			  
        		   }//search row by row of cosine table matrix
        		   }//check for zero in array to skip
        		   
        	   }//searching through users purchased items
        	   /*for(int d=0;d<cosinetable.length;d++){
				   System.out.println();
			      for(int e=0;e<cosinetable.length;e++){
			    	 // if(cosinetable1[d][e].item1val!=0){
				   System.out.print("ctable1_i1v: "+cosinetable1[d][e].item1val+"ctable_i2v: "+cosinetable1[d][e].item2val+"ctable_cval: "+cosinetable1[d][e].cosineval);
			    	 // }
			      }
			   }*/
        	   candidate[] cand1=new candidate[cosinetable.length];
        	   for(int k=0;k<cosinetable.length;k++){
        		   cand1[k]=new candidate();
        	   }
        	   int c9=0;
        	   for(int d=0;d<cosinetable.length;d++){
        		   for(int e=0;e<cosinetable.length;e++){
        			   if(cosinetable1[d][e].item1val!=0){
        				   int c10=0;
        				   for(int k=0;k<cosinetable.length;k++){
        					   if(cosinetable1[d][e].item2val==cand1[k].item1val){
        						   c10=1;
        						   break;
        					   }
        				   }
        				   if(c10!=1){
        				   cand1[c9].item1val=cosinetable1[d][e].item2val;
        				   cand1[c9].cosineval=cosinetable1[d][e].cosineval;
        				   
        				   for(int f=d+1;f<cosinetable.length;f++){
        					   for(int g=0;g<cosinetable.length;g++){
        						   if(cosinetable1[f][g].item1val!=0&&cosinetable1[f][g].item2val==cand1[c9].item1val){
        							   cand1[c9].cosineval=cand1[c9].cosineval+cosinetable1[f][g].cosineval;
        							   break;
        						   }
        					   }
        				   }
        				   c9++;
        			       }
        			   }
        		   }
        	   }
     
        	   sort(cand1);//call sorting function for candidate items.
        	//   System.out.println();
        	   candidate[] cand2=new candidate[ninput];
        	   /*for(int k=0;k<cand1.length;k++){
        	   System.out.print("Cand1itemval: "+cand1[k].item1val+"Cand1cval: "+cand1[k].cosineval);
        	   }*/
        	   for(int k=0;k<cand2.length;k++){
        		   cand2[k]=new candidate();
        	   }
        	   for(int k=0;k<cand2.length;k++){
        		   cand2[k].item1val=cand1[k].item1val;
        		   cand2[k].cosineval=cand1[k].cosineval;
        	   }
        	   pWriter.print("ID "+(i+1));
        	   for(int k=0;k<cand2.length;k++){
        		//   System.out.print("Cand2itemval: "+cand2[k].item1val+"Cand2cval: "+cand2[k].cosineval);   
        		   pWriter.print(" "+cand2[k].item1val+" "+cand2[k].cosineval);
        	   }
        	   pWriter.println();
        	   String d1=sd.nextLine();
       		String d2[]=d1.split(" ");
       		int[] d3=new int[d2.length];
               for(int k=0;k<d2.length;k++){
               	d3[k]=Integer.parseInt(d2[k]);
               }
               
               for(int k=0;k<cand2.length;k++){
            	   if(cand2[k].item1val!=0){
            		   if(cand2[k].item1val==d3[0]){
            			   hits++;
            		       rank=rank+(1/(k+1));
            		   }
            	   }
               }
             //  System.out.println("hits: "+hits);
	System.gc();
}//end each user
         double hr=(double)hits/users;//typecasting for accuracy
         double arhr=(double)rank/users;
         System.out.println("HR is: "+hr);
         System.out.println("ARHR: "+arhr);
     	long endTime1=System.currentTimeMillis();
    	float sec1=0;
    	sec1=(endTime1-startTime1)/1.0f;
    	System.out.print("The Step 2 Execution took ");
    	System.out.format("%.2f",sec1);
    	System.out.println("ms");
    	pWriter.close();
	}
	  
	public static void sort(candidate[] cand1){
          candidate []tempArray = new candidate[cand1.length];
          for(int k=0;k<cand1.length;k++){
   		   tempArray[k]=new candidate();
   	   }
		  mergeSort(tempArray,0,cand1.length-1,cand1);
         return;
	  }
		      public static void mergeSort(candidate[] tempArray,int lowerIndex,int upperIndex,candidate[] cand1){
		          if(lowerIndex == upperIndex){
		              return;
		          }
		          else{
		              int mid = (lowerIndex+upperIndex)/2;
		              mergeSort(tempArray, lowerIndex, mid, cand1);
		              mergeSort(tempArray, mid+1, upperIndex, cand1);
		              merge(tempArray,lowerIndex,mid+1,upperIndex,cand1);
		              }
		          }
		      public static void merge(candidate[] tempArray,int lowerIndexCursor,int higherIndex,int upperIndex, candidate[] cand1){
		          int tempIndex=0;
		          int lowerIndex = lowerIndexCursor;
		          int midIndex = higherIndex-1;
		          int totalItems = upperIndex-lowerIndex+1;
		          while(lowerIndex <= midIndex && higherIndex <= upperIndex){
		              if(cand1[lowerIndex].cosineval > cand1[higherIndex].cosineval){
		                  tempArray[tempIndex].cosineval = cand1[lowerIndex].cosineval;
		                  tempArray[tempIndex].item1val = cand1[lowerIndex].item1val;
		                  lowerIndex++;
		                  tempIndex++;
                      }
		              else{
		                  tempArray[tempIndex].cosineval = cand1[higherIndex].cosineval;
		                  tempArray[tempIndex].item1val = cand1[higherIndex].item1val;
		                  higherIndex++;
		                  tempIndex++;
		              }
		          }
		          while(lowerIndex <= midIndex){
		              tempArray[tempIndex].cosineval = cand1[lowerIndex].cosineval;
		              tempArray[tempIndex].item1val = cand1[lowerIndex].item1val;
		              tempIndex++;
		              lowerIndex++;
		          }
		          while(higherIndex <= upperIndex){
		              tempArray[tempIndex].cosineval = cand1[higherIndex].cosineval;
		              tempArray[tempIndex].item1val = cand1[higherIndex].item1val;
		              tempIndex++;
		              higherIndex++;
		          }
		          for(int i=0;i<totalItems;i++){
		              cand1[lowerIndexCursor+i].cosineval = tempArray[i].cosineval;
		              cand1[lowerIndexCursor+i].item1val = tempArray[i].item1val;
		          }
		      }
		      public static void sort1(cosine[] cosinestr){
		          cosine[] tempArray = new cosine[cosinestr.length];
		          for(int i=0;i<cosinestr.length;i++){
		      		tempArray[i]=new cosine();
		      	}
				  mergeSort1(tempArray,0,cosinestr.length-1,cosinestr);
		         return;
		         }
				      public static void mergeSort1(cosine[] tempArray,int lowerIndex,int upperIndex,cosine[] cosinestr){
				          if(lowerIndex == upperIndex){
				              return;
				          }
				          else{
				              int mid = (lowerIndex+upperIndex)/2;
				              mergeSort1(tempArray, lowerIndex, mid, cosinestr);
				              mergeSort1(tempArray, mid+1, upperIndex, cosinestr);
				              merge1(tempArray,lowerIndex,mid+1,upperIndex,cosinestr);
				          }
				      }
				      public static void merge1(cosine[] tempArray,int lowerIndexCursor,int higherIndex,int upperIndex, cosine[] cosinestr){
				          int tempIndex=0;
				          int lowerIndex = lowerIndexCursor;
				          int midIndex = higherIndex-1;
				          int totalItems = upperIndex-lowerIndex+1;
				          while(lowerIndex <= midIndex && higherIndex <= upperIndex){
				        	  if(cosinestr[lowerIndex].cosineval > cosinestr[higherIndex].cosineval){
				            	  tempArray[tempIndex].cosineval = cosinestr[lowerIndex].cosineval;
				            	  tempArray[tempIndex].item1val = cosinestr[lowerIndex].item1val;
				            	  tempArray[tempIndex].item2val = cosinestr[lowerIndex].item2val;
				            	  tempIndex++;
				            	  lowerIndex++;
				                  }
				              else{
				                  tempArray[tempIndex].cosineval = cosinestr[higherIndex].cosineval;
				                  tempArray[tempIndex].item1val = cosinestr[higherIndex].item1val;
				                  tempArray[tempIndex].item2val = cosinestr[higherIndex].item2val;
				                  tempIndex++;
				                  higherIndex++;
				              }
				          }
				          while(lowerIndex <= midIndex){
				              tempArray[tempIndex].cosineval = cosinestr[lowerIndex].cosineval;
				              tempArray[tempIndex].item1val = cosinestr[lowerIndex].item1val;
				              tempArray[tempIndex].item2val = cosinestr[lowerIndex].item2val;
				              tempIndex++;
				              lowerIndex++;
				          }
				          while(higherIndex <= upperIndex){
				        	  tempArray[tempIndex].cosineval = cosinestr[higherIndex].cosineval;
				        	  tempArray[tempIndex].item1val = cosinestr[higherIndex].item1val;
				        	  tempArray[tempIndex].item2val = cosinestr[higherIndex].item2val;
				              tempIndex++;
				              higherIndex++;
				          }
				          for(int i=0;i<totalItems;i++){
				        	  cosinestr[lowerIndexCursor+i].cosineval = tempArray[i].cosineval;
				        	  cosinestr[lowerIndexCursor+i].item1val = tempArray[i].item1val;
				        	  cosinestr[lowerIndexCursor+i].item2val = tempArray[i].item2val;
				          }
				      }
}


