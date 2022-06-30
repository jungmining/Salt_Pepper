$(function(){
	getJSON();
//	parseJSON();
});

function getJSON(){
	console.log("getJSON 작동");
	$.getJSON("./json/Seoul_AnimalHospital.json",function(data){
	console.log(typeof data,data);
		$.each(data,function(key,value){
			$("table").attr("border","1px");
			if(key=="DESCRIPTION"){
				$("thead").append("<tr><td>"+value.LASTMODTS+"</td><td>"+value.DTLSTATENM+"</td><td>"+value.LINDJOBGBNNM+"</td><td>"+value.BPLCNM+"</td><td>"+value.CLGENDDT+"</td><td>"+value.DCBYMD+"</td><td>"+value.CLGSTDT+"</td><td>"+value.TRDSTATEGBN+"</td><td>"+value.TRDSTATENM+"</td><td>"+value.OPNSFTEAMCODE+"</td><td>"+value.SITETEL+"</td><td>"+value.SITEWHLADDR+"</td><td>"+value.GUOFFICE+"</td><td>"+value.DTLSTATEGBN+"</td><td>"+value.RDNPOSTNO+"</td><td>"+value.UPDATEGBN+"</td><td>"+value.UPDATEDT+"</td><td>"+value.APVPERMYMD+"</td><td>"+value.RDNWHLADDR+"</td><td>"+value.ROPNYMD+"</td><td>"+value.MGTNO+"</td></tr>");
			}else if(key=="DATA"){
				var dList = value;
				for(let i=0; i<dList.length;i++){
					var oneData = dList[i];
				$("tbody").append("<tr><td>"+oneData.lastmodts+"</td><td>"+oneData.dtlstatenm+"</td><td>"+oneData.lindjobgbnnm+"</td><td>"+oneData.bplcnm+"</td><td>"+oneData.clgenddt+"</td><td>"+oneData.dcbymd+"</td><td>"+oneData.clgstdt+"</td><td>"+oneData.trdstategbn+"</td><td>"+oneData.trdstatenm+"</td><td>"+oneData.opnsfteamcode+"</td><td>"+oneData.sitetel+"</td><td>"+oneData.sitewhladdr+"</td><td>"+oneData.guoffice+"</td><td>"+oneData.dtlstategbn+"</td><td>"+oneData.rdnpostno+"</td><td>"+oneData.updategbn+"</td><td>"+oneData.updatedt+"</td><td>"+oneData.apvpermymd+"</td><td>"+oneData.rdnwhladdr+"</td><td>"+oneData.ropnymd+"</td><td>"+oneData.mgtno+
					"<input type='hidden' name='animal' value='"+oneData.lastmodts+"&"+oneData.dtlstatenm+"&"+oneData.lindjobgbnnm+"&"+oneData.bplcnm+"&"+oneData.clgenddt+"&"+oneData.dcbymd+"&"+oneData.clgstdt+"&"+oneData.trdstategbn+"&"+oneData.trdstatenm+"&"+oneData.opnsfteamcode+"&"+oneData.sitetel+"&"+oneData.sitewhladdr+"&"+oneData.guoffice+"&"+oneData.dtlstategbn+"&"+oneData.rdnpostno+"&"+oneData.updategbn+"&"+oneData.updatedt+"&"+oneData.apvpermymd+"&"+oneData.rdnwhladdr+"&"+oneData.ropnymd+"&"+oneData.mgtno+"'>"+"</td></tr>");
					
				}
			}
		});
	});
}

function parseJSON(){
	console.log("getJSON 작동");
	$.getJSON("./json/AnimalHospital.json",function(data){
	console.log(typeof data,data);
		$.ajax({
			url : "./animal.do",
			type : "POST",
			data : {"obj":JSON.stringify(data),"command":"db2"},
			success : function(){
				$.each(data,function(key,value){
					$("table").attr("border","1px");
					if(key=="DESCRIPTION"){
						$("thead").append("<tr><td>"+value.SITEPOSTNO+"</td><td>"+value.RGTMBDSNO+"</td><td>"+value.TOTEPNUM+"</td><td>"+value.UPTAENM+"</td><td>"+value.LASTMODTS+"</td><td>"+value.CLGENDDT+"</td><td>"+value.UPDATEGBN+"</td><td>"+value.RDNWHLADDR+"</td><td>"+value.DCBYMD+"</td><td>"+value.SITEWHLADDR+"</td><td>"+value.Y+"</td><td>"+value.DTLSTATEGBN+"</td><td>"+value.TRDSTATEGBN+"</td><td>"+value.X+"</td><td>"+value.OPNSFTEAMCODE+"</td><td>"+value.APVPERMYMD+"</td><td>"+value.LINDSEQNO+"</td><td>"+value.UPDATEDT+"</td><td>"+value.LINDPRCBGBNNM+"</td><td>"+value.BPLCNM+"</td><td>"+value.CLGSTDT+"</td><td>"+value.RDNPOSTNO+"</td><td>"+value.ROPNYMD+"</td><td>"+value.MGTNO+"</td><td>"+value.LINDJOBGBNNM+"</td><td>"+value.TRDSTATENM+"</td><td>"+value.SITEAREA+"</td><td>"+value.SITETEL+"</td><td>"+value.APVCANCELYMD+"</td><td>"+value.DTLSTATENM+"</td></tr>");
					}else if(key=="DATA"){
						var dList = value;
						for(let i=0; i<dList.length;i++){
							var oneData = dList[i];
						$("tbody").append("<tr><td>"+oneData.sitepostno+"</td><td>"+oneData.rgtmbdsno+"</td><td>"+oneData.totepnum+"</td><td>"+oneData.uptaenm+"</td><td>"+oneData.lastmodts+"</td><td>"+oneData.clgenddt+"</td><td>"+oneData.updategbn+"</td><td>"+oneData.rdnwhladdr+"</td><td>"+oneData.dcbymd+"</td><td>"+oneData.sitewhladdr+"</td><td>"+oneData.y+"</td><td>"+oneData.dtlstategbn+"</td><td>"+oneData.trdstategbn+"</td><td>"+oneData.x+"</td><td>"+oneData.opnsfteamcode+"</td><td>"+oneData.apvpermymd+"</td><td>"+oneData.lindseqno+"</td><td>"+oneData.updatedt+"</td><td>"+oneData.lindprcbgbnnm+"</td><td>"+oneData.bplcnm+"</td><td>"+oneData.clgstdt+"</td><td>"+oneData.rdnpostno+"</td><td>"+oneData.ropnymd+"</td><td>"+oneData.mgtno+"</td><td>"+oneData.lindjobgbnnm+"</td><td>"+oneData.trdstatenm+"</td><td>"+oneData.sitearea+"</td><td>"+oneData.sitetel+"</td><td>"+oneData.apvcancelymd+"</td><td>"+oneData.dtlstatenm+"</td>"+
							"<input type='hidden' name='animal' value='"+oneData.sitepostno+"/"+oneData.rgtmbdsno+"/"+oneData.totepnum+"/"+oneData.uptaenm+"/"+oneData.lastmodts+"/"+oneData.clgenddt+"/"+oneData.updategbn+"/"+oneData.rdnwhladdr+"/"+oneData.dcbymd+"/"+oneData.sitewhladdr+"/"+oneData.y+"/"+oneData.dtlstategbn+"/"+oneData.trdstategbn+"/"+oneData.x+"/"+oneData.opnsfteamcode+"/"+oneData.apvpermymd+"/"+oneData.lindseqno+"/"+oneData.updatedt+"/"+oneData.lindprcbgbnnm+"/"+oneData.bplcnm+"/"+oneData.clgstdt+"/"+oneData.rdnpostno+"/"+oneData.ropnymd+"/"+oneData.mgtno+"/"+oneData.lindjobgbnnm+"/"+oneData.trdstatenm+"/"+oneData.sitearea+"/"+oneData.sitetel+"/"+oneData.apvcancelymd+"/"+oneData.dtlstatenm+">"+"</tr>");
							
						}
					}
				});
			},
			error : function(){
				console.log("잘못된 접근");
			}
		});

	});
}