<?php

function copyright($initialYear) {
	$copyrightYear = date("Y");
	if($initialYear < $copyrightYear) :
	echo "Copyright &copy; $initialYear - $copyrightYear";
	
	else :
	echo "Copyright &copy; $initialYear";
	
	endif;
}

copyright("2050");