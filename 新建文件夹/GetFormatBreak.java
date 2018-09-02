class GetFormatBreak{
	GetFormatBreak(String forBreak,int length){
		
        int aLength = forBreak.length();
        if(length>aLength){
            int i = length-aLength;
			forBreak ="";
            for (int j = 0; j < i; j++) {
                forBreak +=" ";
            }
        }
        this.formatBreak=forBreak;
	}
	String formatBreak = "";
}