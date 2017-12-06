class Poly
{
  private Term head; 
  private class Term
  { 
    int coef;
    int expo;
    Term next;

  private Term(int coef, int expo, Term next)
  {
    this.coef = coef; 
    this.expo = expo;
    this.next = next;
  }
  }

 

  public Poly()
  {
    head = new Term(0, 0, null); 
  }

  public Poly term(int coef, int expo)
  {
	  Term front = head; 
	    Term end = head.next;
	    if(expo < 0)
	    {
	      throw new IllegalArgumentException("Exponent cannot be negative");
	    }
	    else
	    {
	      while(end != null) 
	      {
	        if(end.expo < expo) 
	        {
	          front.next = new Term(coef, expo, end);
	          return this;
	        }

	        else if(end.expo == expo)
	        {
	          throw new IllegalArgumentException("use plus method");
	        }

	        else 
	        {
	          front = end;
	          end = end.next;
	        }
	      }
	      if(end == null) 
	      {
	        end = new Term(coef, expo, null);
	      }
	    }
	    front.next = new Term(coef, expo, null);
	    return this;
  }

  public Poly plus(Poly that)
  {
    Poly p = this;
    Poly res = new Poly();
    Term front = p.head;
    Term end= p.head.next;
    while(end != null) 
    {
      res.term(end.coef, end.expo);
      front = end;
      end = end.next;
    }
    front = that.head;
    end = that.head.next;
    Term front2 = res.head;
    Term end2 = res.head.next;
    while(end != null)
    {
      while(end2 != null) 
      {
        if(end2.expo < end.expo)
        {
         front2.next = new Term(end.coef, end.expo, end2);
          break;
        }

        else if(end2.expo == end.expo) 
        {
          end2.coef += end.coef;
          break;
        }

        else 
        {
          front2 = end2;
          end2 = end2.next;
        }
      }
      front = end;
      end = end.next;

    }
    return res;

  }

  public void add(int coef, int expo)
  {
    if(expo < 0)
    {
      throw new IllegalArgumentException("no negative exponents");
    }
    else
    {
      Term front = head; 
      Term end = head.next;
      while(end != null)  
      {
        if(end.expo < expo)
        {
          front.next = new Term(coef, expo, end);
          break;
        }

        else if(end.expo == expo)
        {
          end.coef += coef;
          if(end.coef == 0)
          {
            front.next = end.next;
          }
          break;
        }

        else
        {
          front = end;
          end = end.next;
        }

      }
    }
    System.out.println(this);
  }

  public Poly minus()
  {
    Poly p = this;
    Poly res = new Poly(); 
    Term front = p.head;
    Term end = p.head.next;
    while(end != null)
    {
      res.term(end.coef, end.expo);
      front = end;
      end = end.next;
    }
    end = res.head;
    front = res.head.next;

    while(end != null)
    {
      end.coef = (-end.coef);
      front = end;
      end = end.next;
    }

    return res;

  }
  public String toString()
  {
    StringBuilder builder = new StringBuilder();
   
    Term end = head.next;
    if(end == null) 
    {
      builder.append("0");
    }
    else
    {
      builder.append(end.coef + "x^" + end.expo); 
      Term temp = end.next;
      while(temp != null) 
      {
        if(temp.coef > 0) 
          {
            builder.append(" + " + temp.coef + "x^" + temp.expo);
          }
        else if(temp.coef < 0) 
          builder.append(" - " + (-temp.coef) + "x^" + temp.expo);

        temp = temp.next;
      }
    }

    return builder.toString();
  }


}

//OUTPUT
//0
//1x^3 + 1x^2 + 1x^1
//3x^2 + 2x^1
//-3x^2 - 2x^1
//1x^3 + 4x^2 + 3x^1
//1x^3 - 2x^2 - 1x^1


  class PollyEsther  //driver
  {  
    public static void main(String[] args)  
    {  
      Poly p0 = new Poly();  
      Poly p1 = new Poly().term(1, 3).term(1, 1).term(1, 2);  
      Poly p2 = new Poly().term(2, 1).term(3, 2);  
      Poly p3 = p2.minus();  
    
      System.out.println(p0);           //  0  
      System.out.println(p1);           //  1x3 + 1x2 + 1x1  
      System.out.println(p2);           //  3x2 + 2x1  
      System.out.println(p3);           //  −3x2 − 2x1  
    
      System.out.println(p1.plus(p2));  //  1x3 + 4x2 + 3x1  
      System.out.println(p1.plus(p3));  //  1x3 − 2x2 − 1x1  
    }  
  }

