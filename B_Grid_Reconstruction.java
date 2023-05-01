char s[7<<15];
m=3e5;
main(i,x,y,r){
    for(
        scanf("%*d");
        ~scanf("%s",s);)
        {int a[3]={0};
        for(i=r=m;x=s[i-m];)
        {
    a[x%3]=i++;
    y=a[(x+1)%3];
    x=a[(x+2)%3];
    x=i-(x<y?x:y);
    r=x<r?x:r;
}
    printf("%d ",r%m);
}}
    