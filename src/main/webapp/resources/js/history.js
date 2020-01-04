/**
 * @Description : window.history 기능관련 js 플로그인
 */

(function($) {

	/*
	 * 뒤로가기 기능 버특ㄴ 막기 옵션
	 * true : 막기
	 * false : window.history 기능 제공
	 */
	var preventHistory = true;
	var noneHtml5Browsers = /MSIE 8.0/.test(navigator.userAgent) || /MSIE 9.0/.test(navigator.userAgent) || /MSIE 7.0/.test(navigator.userAgent);
    var safariBrowser = (!/Chrome/.test(navigator.userAgent) && /Safari/.test(navigator.userAgent)) || /Chrome\/29/.test(navigator.userAgent);

    var contextPath =  location.href.match(/^(?:\w+):\/\/(?:[\w.]+)(?:(?::[\d]*)?)\/(?:[\w]+)[^\/]/);
    
    var histMessage = "초기페이지로 이동합니다";
    
    $.stkHistory = function(options) {
        if(!preventHistory) {
            this.options = $.extend({}, $.jquery.options,options || {});
            fx.push(this.options);
        }
    return this;
    }
    
    var fx = {
        init:function() {
            /*
            * 뒤로가기 막기
            */
            if(preventHistory) {
              $(document).ready(function() {
                  $('body').on('click','a',function(e) {
                     var invalidList = ['javascript'];
                     var isPrevent = false;
                     var str = $(this).attr('href');
                      
                      if(str) {
                          $.each(invalidList,function(idx, val) {
                             if(str.indexOf(val) > -1) {
                                 isPrevent = false;
                                 return false;
                             } else {
                                 isPrevent = true;
                             }
                          });
                      }
                      
                      if(isPrevent) {
                          e.preventDefault();
                      }
                  });
                  
                  if(!noneHtml5Browsers) {
                      history.pushState({noBubbling: true}, null, location.href);
                  }
                  
              });
                
                /*
                * html5 브라우저 (chrome firefox safari ie10이상)
                */
                if(!noneHtml5Browsers) {
                    
                    // 세션 히스토리 항목으로, 이동할때마다 이벤트가 발생.
                    $(window).on('popstate', function(e) {
                        if(location.href.indexOf("#") < 0) {
                            history.pushState({noBubbling:true},null,location.href);
                        }
                        
                        //safari, chrome 구버전에서 초기페이지 alert메세지 방지
                        if(safariBrowser) {
                            if(!e.originalEvent.state) return;
                        }
                        
                        if(confirm(histMessage)) {
                            
                            window.location.href = contextPath;
                        }
                    });
                    
                // html5 브라우저가 아닌경우 (ie8, ie9)
                } else {
                    var hash = 0, hashArr= [];
                    var popstateId = setInterval(function() {
                       if(hashArr.length < 3) {
                           if(location.hash != '') {
                               hash = Number(location.hash.replace('#','')) + 1;
                           } else {
                               hash = hash +1;
                           }
                           location.hash = hash;
                           hashArr.unshift(hash);
                       } 
                    }, 500);
                    
                    
                    // 해시(#) 만 다른 세션 히스토리 항목으로 이동할때 hashchange 이벤트가 발생.
                    $(window).on('hashchange', function(e) {
                       var curHash = location.hash.replace('#', '');
                        
                        if(locatioin.hash != '#' && !isNaN(Number(curHash))) {
                            if(hashArr.length >0 && hashArr[0] != curHash) {
                                hashArr.shift();
                                if(confirm(histMessage)) {
                                    clearInterval(popstateId);
                                    window.location.href = contextPath ;
                                }
                            }
                        } else {
                            history.back();
                        }
                    });
                    
                }
                
                
               /*
               * 뒤로가기 허용
               */
            } else {
                
                
            }
        },
            
            /*
            * push
            */
            push:function(options) {
                if(!noneHtml5Browsers) {
                    history.pushState(options,options.title,location.pathname);
                } else {
                    
                    var stkHistory = $(window).data('stkHistory');
                    var hashArr = undefined;
                    var preOptions = {};
                    
                    if(stkHistory && stkHistory.hashArr && stkHistory.length >0) {
                        options.hash = Number(stkHistory.hashArr[0].hash) +1 ;
                        hashArr = stkHistory.hashArr;
                        preOptions - hashArr[0];
                    } else {
                        hashArr = [];
                    }
                    
                    hashArr.unshift($.extend({preOptions:preOptions}, options));
                    $(window).data('stkHistory',{hashArr:hashArr});
                    location.hash = options.hash;
                }
            }
         
            
            
            
            
    };
    
    fx.init();
    
    $.stkHistory.options = {
                title: '',
                url:'',
                param: {},
                hash:1,
                container:'#maincontent'
    };
            
    
})(jQuery);

















