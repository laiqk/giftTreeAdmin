/*! Tomcat360.com
 * (c) 2015 Jerry
 */
define("main/jump",["jQuery"],function(e){"use strict";var t=e("jQuery");t(function(){var e=t("#timer").data("seconds"),n=setInterval(function(){e--,e>=0?t("#timer").text(e):(clearInterval(n),window.location.href=t("#timer").data("url"))},1e3)})});