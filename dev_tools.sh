#!/usr/bin/env bash 

set -e  

# cd "$(dirname $0)"
root_folder=$(cd `dirname $0`; pwd)
cd $root_folder


function run_eureka () {
    cd $root_folder/eureka
    mvn clean package
    java -jar target/eureka*.jar
}

function run_eureka_client () {
    cd $root_folder/eureka-clent
    mvn clean package
    java -jar target/eureka*.jar
}

# add new cmd entry here 

cmds=( \ 

run_eureka \ 

run_eureka_client \ 

) 

function do_command () { 

    case $1 in 

        run_eureka) 
            run_eureka 
            ;; 

        run_eureka_client) 
            run_eureka_client 
            ;; 

        *) 

            echo "Please select what you want to do:" 

            ;; 

    esac 

} 

 

# functional codes for this shell, you can ignore 

function select_cmd () { 

    echo "Please select what you want to do:" 

    select CMD in ${cmds[*]}; do 

        if [[  $(in_array $CMD ${cmds[*]}) = 0 ]]; then 

            do_command $CMD 

            break 

        fi 

    done 

} 
 
function select_arg () { 

    cmd=$1 

    shift 1 

    options=("$@") 

 

    echo "Please select which arg you want:" 

    select ARG in ${options[*]}; do 

        if [[  $(in_array ${ARG} ${options[*]}) = 0 ]]; then 

            ${cmd} ${ARG} 

            break 

        fi 

    done 

} 

function in_array () { 

    TARGET=$1 

    shift 1 

    for ELEMENT in $*; do 

        if [[ "$TARGET" == "$ELEMENT" ]]; then 

            echo 0 

            return 0 

        fi 

    done 

    echo 1 

    return 1 
} 

function main () { 
    if [[ $1 != "" && $(in_array $1 ${cmds[*]}) = 0 ]]; then 
        do_command $* 
    else 
        select_cmd 
    fi 
} 

main $* 
