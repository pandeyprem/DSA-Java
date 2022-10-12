class Date 
{
    public static void main(String[] args)
    {
        String[] day={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		int date=Integer.parseInt(args[0]);
		int month=Integer.parseInt(args[1]);
		int year=Integer.parseInt(args[2]);
		int[] mon={11,12,1,2,3,4,5,6,7,8,9,10};
        if(month<=2)
        {
            year--;
        }
        int D=year%100;
		int C=year/100;
        int F=date+ ((13*mon[month-1]-1)/5) +D+ (D/4) +(C/4)-2*C;
        int days=F%7;
        System.out.println(day[days]);
    }
}
