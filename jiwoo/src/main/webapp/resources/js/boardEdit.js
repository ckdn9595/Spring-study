var cno = 1;
function getCno(){
	return cno;
}
function setCno(n){
	cno = n;
	return cno;
}
$(document).ready(function(){
	function chEvt(){
		
		let tno = getCno();
		let cnt = document.getElementsByClassName('upfile').length;
		if(tno == cnt){
			$('.upfile').eq(cnt - 1).on('change', chEvt);
		} else {
			setCno(cnt);
		}
		if(cnt == 1){
			$('#fileimg').slideUp(500, function(){
				$('#fileimg').removeClass('mt10 pdt10 w3-border w3-border-blue w3-round-large');
			});
		} else if(cnt == 2){
			$('#fileimg').addClass('mt10 pdt10 w3-border w3-border-blue w3-round-large');
			$('#fileimg').stop().slideDown(500);
		}
	}
	
	$('.upfile').on('change', chEvt);
	
	// 이미지 클릭이벤트
	$('.imgLink').click(function(){
		let tno = $(this).attr('id');
		let tname = $(this).children().first().attr('src');
		let tmp = $(this).next().children().first().text();
		let toname = tmp.substring(tmp.lastIndexOf('/') + 1);
		let tlen = $(this).next().next().text();
		let tdate = $(this).siblings().eq(2).text();
		
		$('#mImg').attr('src', tname);
		$('#mfno').text(tno);
		$('#moname').text(toname);
		$('#mlen').text(tlen);
		$('#mdate').text(tdate);
		
		$('#mImg').on('load', function(){
			resize(this, 'addImgW3', 'addImgH3');
		});
		$('#fileEditModal').css('display', 'block');
	});
	
	$('.closeBtn').click(function(){
		$('#mImg').attr('src', '');
		$('#mfno').text('');
		$('#moname').text('');
		$('#mlen').text('');
		$('#mdate').text('');
		
		$('#fileEditModal').css('display', 'none');
	});
	
	$('#delBtn').click(function(){
		var tno = $('#mfno').html();
		$.ajax({
			url: '/cls/board/boardDelImg.cls',
			type: 'POST',
			dataType: 'json',
			data: {
				fno: tno
			},
			success: function(obj){
				alert(tno);
				if(obj.cnt == 1){
					$('#fr'+tno).remove();
					$('#fileEditModal').css('display', 'none');
				} else {
					return;
				}
			},
			error: function(){
				alert('### 통신 실패 ###');
			}
		});
	});
});